package com.example.layeredarchitecture.bo;


import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public ArrayList<CustomerDTO> loadAll() throws SQLException, ClassNotFoundException;
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public ResultSet generate() throws SQLException, ClassNotFoundException;
    public ResultSet search(String newValue) throws SQLException, ClassNotFoundException;
}
