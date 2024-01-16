package lk.ijse.aad_assignment_01.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.aad_assignment_01.db.CustomerDB;
import lk.ijse.aad_assignment_01.dto.CustomerDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "customer",urlPatterns = "/customer")
public class Customer extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/pos");
            this.connection = pool.getConnection();
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

        System.out.println(customerDTO.getCus_id());
        System.out.println(customerDTO.getName());
        System.out.println(customerDTO.getNic());
        System.out.println(customerDTO.getAddress());


        CustomerDB customerDB = new CustomerDB();

        if (customerDB.saveCustomer(customerDTO,connection)){
            PrintWriter writer = resp.getWriter();
            writer.write("Customer Saved ...");
        }
    }
}
