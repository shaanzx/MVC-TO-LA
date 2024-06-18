package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public ArrayList<T> loadAll() throws SQLException, ClassNotFoundException;
    public boolean save(T t) throws SQLException, ClassNotFoundException ;
    public boolean update(T t ) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public ResultSet generate() throws SQLException, ClassNotFoundException;
    public ResultSet search(String newValue) throws SQLException, ClassNotFoundException;




}
