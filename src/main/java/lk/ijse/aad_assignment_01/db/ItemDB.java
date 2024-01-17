package lk.ijse.aad_assignment_01.db;

import lk.ijse.aad_assignment_01.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemDB {

    public boolean saveItem(ItemDTO itemDTO, Connection connection) {
        String saveItem = "INSERT INTO item(item_id,item_name,qty,price) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveItem);
            preparedStatement.setString(1,itemDTO.getItem_id());
            preparedStatement.setString(2,itemDTO.getItem_name());
            preparedStatement.setString(3, String.valueOf(itemDTO.getQty()));
            preparedStatement.setString(4, String.valueOf(itemDTO.getPrice()));

            return preparedStatement.executeUpdate()!=0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemDTO> getAllItem(Connection connection) {
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from item");
            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()){
                itemDTOS.add(new ItemDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getDouble(4)
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return itemDTOS;
    }

    public boolean updateItem(ItemDTO itemDTO, Connection connection) {
        try {
            var preparedStatement = connection.prepareStatement("UPDATE item set item_name=?, qty=?, price=? where item_id=?");
            preparedStatement.setString(1, itemDTO.getItem_name());
            preparedStatement.setInt(2, itemDTO.getQty());
            preparedStatement.setDouble(3, itemDTO.getPrice());
            preparedStatement.setString(4, itemDTO.getItem_id());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}