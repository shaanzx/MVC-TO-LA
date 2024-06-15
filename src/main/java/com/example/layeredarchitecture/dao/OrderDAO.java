package com.example.layeredarchitecture.dao;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
    ResultSet generateOrderId() throws SQLException, ClassNotFoundException;

    void existOrderId(String orderId) throws SQLException, ClassNotFoundException;

    PreparedStatement saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
