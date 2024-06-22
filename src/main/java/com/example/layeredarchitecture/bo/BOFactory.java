package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    public static BOFactory boFactory;

    public enum BOType{
        CUSTOMER,ITEM,PLACE_ORDER
    }
    private BOFactory() {}

    public static BOFactory getDAOFactory (){
       return  (boFactory == null)? boFactory=new BOFactory():boFactory;
    }
    public SuperBO getBOType(BOType type){
        switch (type){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            default:
               return null;
        }
    }
}
