package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
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
    public boolean saveItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
/*        Connection connection = DBConnection.getDbConnection().getConnection();
        pstm.setString(1, code);
        pstm.setString(2, description);
        pstm.setBigDecimal(3, unitPrice);
        pstm.setInt(4, qtyOnHand);
        pstm.executeUpdate();*/
        return SqlUtil.executeQuery("INSERT INTO item (code, description,  unitPrice, qtyOnHand) VALUES (?,?,?,?)",code,description,unitPrice,qtyOnHand);
    }
   @Override
    public boolean updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",description,unitPrice,qtyOnHand,code);
    }
    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return SqlUtil.executeQuery("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean exitItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet =  SqlUtil.executeQuery("SELECT code FROM Item WHERE code=?",code);
        return resultSet.next();

    }
    @Override
    public ResultSet generateNextItemId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        return resultSet;
    }
    @Override
    public ResultSet findItem(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SqlUtil.executeQuery("SELECT * FROM Item WHERE code=?",newItemCode);
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
