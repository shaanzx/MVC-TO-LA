package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;
    public boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException;
    public ResultSet searchCustomerId(String newValue) throws SQLException, ClassNotFoundException;
}
