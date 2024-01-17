package lk.ijse.aad_assignment_01.db;

import lk.ijse.aad_assignment_01.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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

}
