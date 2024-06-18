package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
  /*  public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException ;
    public boolean updateCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException;
    public ResultSet searchCustomerId(String newValue) throws SQLException, ClassNotFoundException;*/
}
