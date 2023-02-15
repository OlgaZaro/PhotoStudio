package com.solvd.photostudio.mybatis.mapper;

import com.solvd.photostudio.model.ServiceOrder;
import org.apache.ibatis.annotations.*;

import java.util.Map;


public interface ServiceOrderMapper {

    @Select("SELECT id, orderPrice, customer_id FROM serviceOrder WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderPrice", column = "orderPrice"),
            @Result(property = "customerId", column = "customer_id")})
    ServiceOrder getServiceOrderById(Integer id);

    @Select("SELECT * FROM serviceOrder")
    @MapKey("id")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderPrice", column = "orderPrice"),
            @Result(property = "customerId", column = "customer_id")})
    Map<Integer, ServiceOrder> getAllServiceOrder();

    @Update("UPDATE serviceOrder SET orderPrice = #{orderPrice}, customer_id = #{customerId} WHERE id =#{id}")
    void updateServiceOrder(ServiceOrder serviceOrder);

    @Insert("INSERT into serviceOrder(id, orderPrice, customer_id ) VALUES (#{id},#{orderPrice},#{customerId})")
    void saveServiceOrder(ServiceOrder serviceOrder);

    @Delete("DELETE FROM serviceOrder WHERE id =#{id}")
    void deleteServiceOrder(ServiceOrder serviceOrder);
}
