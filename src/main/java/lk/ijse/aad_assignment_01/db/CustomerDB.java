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
}
