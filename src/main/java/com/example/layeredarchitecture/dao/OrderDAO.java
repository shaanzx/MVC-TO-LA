package com.example.layeredarchitecture.dao;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
    ResultSet generateOrderId() throws SQLException, ClassNotFoundException;

    boolean existOrderId(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
