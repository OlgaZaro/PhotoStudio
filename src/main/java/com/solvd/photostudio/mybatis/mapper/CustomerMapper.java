package com.solvd.photostudio.mybatis.mapper;

import com.solvd.photostudio.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.Map;


public interface CustomerMapper {

        @Select("SELECT id, firstName, lastName, phone, mail FROM customer WHERE id=#{id}")
        @Results(value = {
                @Result(property = "id", column = "id"),
                @Result(property = "firstName", column = "firstName"),
                @Result(property = "lastName", column = "lastName"),
                @Result(property = "phone", column = "phone"),
                @Result(property = "mail", column = "mail")})

        Customer getCustomerById(Integer id);
        @Select("SELECT * FROM customer")
        @MapKey("id")
        @Results(value = {
                @Result(property = "id", column = "id"),
                @Result(property = "firstName", column = "firstName"),
                @Result(property = "lastName", column = "lastName"),
                @Result(property = "phone", column = "phone"),
                @Result(property = "mail", column = "mail")})

        Map<Integer, Customer> getAllCustomer();

        @Update("UPDATE customer SET firstName = #{firstName}, lastName = #{lastName}, phone = #{phone}, mail = #{mail} WHERE id=#{id}")
        void updateCustomer(Customer customer);

        @Insert("INSERT into customer(id, firstName, lastName, phone, mail ) VALUES (#{id},#{firstName},#{lastName},#{phone},#{mail})")
        void saveCustomer(Customer customer);

        @Delete("DELETE FROM customer WHERE id=#{id}")
        void deleteCustomer(Customer customer);
}

