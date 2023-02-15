package com.solvd.photostudio.mybatis.mapper;

import com.solvd.photostudio.model.Subscription;
import org.apache.ibatis.annotations.*;

import java.util.Map;


public interface SubscriptionMapper {

    @Select("SELECT id, title, subscriptionPrice, customer_id  FROM subscription WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "subscriptionPrice", column = "subscriptionPrice"),
            @Result(property = "customerId", column = "customer_id")})
    Subscription getSubscriptionById(Integer id);

    @Select("SELECT * FROM subscription")
    @MapKey("id")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "subscriptionPrice", column = "subscriptionPrice"),
            @Result(property = "customerId", column = "customer_id")})

    Map<Integer, Subscription> getAllSubscription();

    @Update("UPDATE subscription SET title = #{title}, subscriptionPrice = #{subscriptionPrice}, customer_id = #{customerId}")
    void updateSubscription(Subscription subscription);

    @Insert("INSERT into subscription(id, title, subscriptionPrice, customer_id ) VALUES (#{id},#{title},#{subscriptionPrice},#{customerId})")
    void saveSubscription(Subscription subscription);

    @Delete("DELETE FROM subscription WHERE id=#{id}")
    void deleteSubscription(Subscription subscription);
}
