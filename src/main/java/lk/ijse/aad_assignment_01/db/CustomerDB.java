package lk.ijse.aad_assignment_01.db;

import lk.ijse.aad_assignment_01.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDB {

    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection){
        String saveCustomer = "INSERT INTO customer(cus_id,name,nic,address) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveCustomer);
            preparedStatement.setString(1,customerDTO.getCus_id());
            preparedStatement.setString(2,customerDTO.getName());
            preparedStatement.setString(3,customerDTO.getNic());
            preparedStatement.setString(4,customerDTO.getAddress());

            return preparedStatement.executeUpdate()!=0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAllCustomer(Connection connection) {
    }

    public boolean updateCustomer(CustomerDTO customerDTO, Connection connection) {
        try {
            var preparedStatement = connection.prepareStatement("UPDATE customer set name=?, nic=?, address=? where cus_id=?");
            preparedStatement.setString(1, customerDTO.getName());
            preparedStatement.setString(2, customerDTO.getNic());
            preparedStatement.setString(3, customerDTO.getAddress());
            preparedStatement.setString(4, customerDTO.getCus_id());

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
