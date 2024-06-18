package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO {
    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;

    boolean saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean exitItem(String code) throws SQLException, ClassNotFoundException;

    ResultSet generateNextItemId() throws SQLException, ClassNotFoundException;

    ResultSet findItem(String newItemCode) throws SQLException, ClassNotFoundException;

    boolean updateItemQty(List<OrderDetailDTO> orderDetails, ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean updateItemQty(OrderDetailDTO orderDetail, ItemDTO item) throws SQLException, ClassNotFoundException;

    ResultSet FindItem(String code) throws SQLException, ClassNotFoundException;
}
