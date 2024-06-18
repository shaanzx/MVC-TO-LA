package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<ItemDTO> {
/*    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;

    boolean saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    boolean exitItem(String code) throws SQLException, ClassNotFoundException;

    ResultSet generateNextItemId() throws SQLException, ClassNotFoundException;*/

    ResultSet find(String code) throws SQLException, ClassNotFoundException;

    boolean updateItemQty(List<OrderDetailDTO> orderDetails, ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean updateItemQty(OrderDetailDTO orderDetail, ItemDTO item) throws SQLException, ClassNotFoundException;

    ResultSet FindItem(String code) throws SQLException, ClassNotFoundException;
}
