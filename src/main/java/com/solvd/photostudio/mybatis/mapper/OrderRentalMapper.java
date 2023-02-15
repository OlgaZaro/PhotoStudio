package com.solvd.photostudio.mybatis.mapper;

import com.solvd.photostudio.model.OrderRental;
import org.apache.ibatis.annotations.*;

import java.util.Map;


public interface OrderRentalMapper {

    @Select("SELECT id, orderPrice, customer_id FROM orderRental WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderPrice", column = "orderPrice"),
            @Result(property = "customerId", column = "customer_id")})
    OrderRental getOrderRentalById(Integer id);

    @Select("SELECT * FROM orderRental")
    @MapKey("id")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderPrice", column = "orderPrice"),
            @Result(property = "customerId", column = "customer_id")})
    Map<Integer, OrderRental> getAllOrderRental();

    @Update("UPDATE orderRental SET orderPrice = #{orderPrice}, customer_id = #{customerId} WHERE id =#{id}")
    void updateOrderRental(OrderRental orderRental);

    @Insert("INSERT into orderRental(id, orderPrice, customer_id ) VALUES (#{id},#{orderPrice},#{customerId})")
    void saveOrderRental(OrderRental orderRental);

    @Delete("DELETE FROM orderRental WHERE id =#{id}")
    void deleteOrderRental(OrderRental orderRental);
}
