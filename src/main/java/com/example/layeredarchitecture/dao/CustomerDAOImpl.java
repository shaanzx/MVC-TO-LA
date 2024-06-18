package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    CustomerDTO customerDTO = new  CustomerDTO();
    @Override
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
    @Override
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",id,name,address);
    }
    @Override
    public boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {
       return SqlUtil.executeQuery("UPDATE Customer SET name=?, address=? WHERE id=?",name,address,id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("DELETE FROM Customer WHERE id=?", id);
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
       ResultSet resultSet =  SqlUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id);
       return resultSet.next();
    }
    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        return rst;
    }
    @Override
    public ResultSet searchCustomerId(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT * FROM Customer WHERE id=?",newValue);
        return resultSet;
    }
}
