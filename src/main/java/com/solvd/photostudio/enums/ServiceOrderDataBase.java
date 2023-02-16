package com.solvd.photostudio.enums;

import com.solvd.photostudio.model.ServiceOrder;
import java.util.ArrayList;
import java.util.List;


public enum ServiceOrderDataBase {

    SERVICE_ORDER_1(1, "1500", 5),
    SERVICE_ORDER_2(2, "1200", 2),
    SERVICE_ORDER_3(3, "1700", 4);

    private final int id;
    private final String orderPrice;
    private final int customerId;


    ServiceOrderDataBase(int id, String orderPrice, int customerId) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }

    public static List<ServiceOrder> fromServiceOrderDataBase() {
        List<ServiceOrder> serviceOrderList = new ArrayList<>();
        for (ServiceOrderDataBase serviceOrder : values()) {
            serviceOrderList.add(new ServiceOrder(serviceOrder.id, serviceOrder.orderPrice, serviceOrder.customerId));
        }
        return serviceOrderList;
    }
}
