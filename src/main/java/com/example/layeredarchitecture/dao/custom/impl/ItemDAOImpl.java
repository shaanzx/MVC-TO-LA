package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            itemDTOS.add(itemDTO);
        }
        return itemDTOS;
    }
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("INSERT INTO item (code, description,  unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
   @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }
    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =  SqlUtil.executeQuery("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();

    }
    @Override
    public ResultSet generate() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        return resultSet;
    }

    @Override
    public ResultSet search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet find(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT * FROM Item WHERE code=?", code);
        return resultSet;
    }
    @Override
    public boolean updateItemQty(List<OrderDetailDTO> orderDetails, ItemDTO item) throws SQLException, ClassNotFoundException {
        for(OrderDetailDTO orderDetail : orderDetails) {
            if(!updateItemQty(orderDetail,item)){
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean updateItemQty(OrderDetailDTO orderDetail, ItemDTO item) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),orderDetail.getItemCode());

    }
    @Override
    public ResultSet FindItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT * FROM Item WHERE code=?",code);
        resultSet.next();
        return resultSet;
    }
}
