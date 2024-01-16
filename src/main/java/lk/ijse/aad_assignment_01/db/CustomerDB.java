package lk.ijse.aad_assignment_01.db;

import lk.ijse.aad_assignment_01.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDB {
    final static Logger logger = LoggerFactory.getLogger(CustomerDB.class);

    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection){
        try {
            var ps = connection.prepareStatement("INSERT INTO customer(cus_id,name,nic,address) VALUES (?,?,?,?)");
            ps.setString(1,customerDTO.getCus_id());
            ps.setString(2,customerDTO.getName());
            ps.setString(3,customerDTO.getNic());
            ps.setString(4,customerDTO.getAddress());

            if (ps.executeUpdate() != 0) {
                logger.info("Customer Data saved");
                return true;
            } else {
                logger.error("Customer Data not saved");
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
