package com.solvd.photostudio.mybatis.mapper;

import com.solvd.photostudio.model.GiftCertificate;
import org.apache.ibatis.annotations.*;

import java.util.Map;


public interface GiftCertificateMapper {

    @Select("SELECT id, certificatePrice, serviceOrder_Id FROM giftCertificate WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "certificatePrice", column = "certificatePrice"),
            @Result(property = "serviceOrderId", column = "serviceOrder_Id")})

    GiftCertificate getGiftCertificateById(Integer id);

    @Select("SELECT * FROM giftCertificate")
    @MapKey("id")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "certificatePrice", column = "certificatePrice"),
            @Result(property = "serviceOrderId", column = "serviceOrder_Id")})

    Map<Integer, GiftCertificate> getAllGiftCertificate();

    @Update("UPDATE giftCertificate SET certificatePrice = #{certificatePrice}, serviceOrder_Id = #{serviceOrderId} WHERE id =#{id}")
    void updateGiftCertificate(GiftCertificate giftCertificate);

    @Insert("INSERT into giftCertificate(id, certificatePrice, serviceOrder_Id ) VALUES (#{id},#{certificatePrice},#{serviceOrderId})")
    void saveGiftCertificate(GiftCertificate giftCertificate);

    @Delete("DELETE FROM giftCertificate WHERE id =#{id}")
    void deleteGiftCertificate(GiftCertificate giftCertificate);
}
