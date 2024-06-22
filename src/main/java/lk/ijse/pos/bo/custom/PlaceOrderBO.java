package lk.ijse.pos.bo.custom;


import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
     CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;

     ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

     boolean existItem(String code) throws SQLException, ClassNotFoundException;

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

     String generateOrderID() throws SQLException, ClassNotFoundException ;

     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

     boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

     ItemDTO findItem(String code);
}

