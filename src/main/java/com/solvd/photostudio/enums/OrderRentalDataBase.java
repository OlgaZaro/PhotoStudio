package com.solvd.photostudio.enums;

import com.solvd.photostudio.model.OrderRental;
import java.util.ArrayList;
import java.util.List;

public enum OrderRentalDataBase {

    ORDER_RENTAL_1(1, "2000", 2),
    ORDER_RENTAL_2(2, "3000", 1),
    ORDER_RENTAL_3(3, "5000", 3);

    private final int id;
    private final String orderPrice;
    private final int customerId;

    OrderRentalDataBase(int id, String orderPrice, int customerId) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }


    public static List<OrderRental> fromOrderRentalDataBase() {
        List<OrderRental> orderRentalList = new ArrayList<>();
        for (OrderRentalDataBase orderRental : values()) {
            orderRentalList.add(new OrderRental(orderRental.id, orderRental.orderPrice, orderRental.customerId));
        }
        return orderRentalList;
    }
}
