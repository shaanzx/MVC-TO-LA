package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailDAO {
   @Override
    public boolean saveOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException {
        for (OrderDetailDTO detail : orderDetails) {
            if(!saveOrderDetails(detail,orderId)){
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean saveOrderDetails(OrderDetailDTO details, String orderId) throws SQLException, ClassNotFoundException {
/*        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm =  connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
            stm.setString(1, orderId);
            stm.setString(2, details.getItemCode());
            stm.setBigDecimal(3, details.getUnitPrice());
            stm.setInt(4, details.getQty());
            return stm.executeUpdate() > 0;*/
            return SqlUtil.executeQuery("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,details.getItemCode(),details.getUnitPrice(),details.getQty());
    }
}
