package com.solvd.photostudio.mybatis.mybatisservise;


import com.solvd.photostudio.model.OrderRental;
import com.solvd.photostudio.mybatis.mapper.OrderRentalMapper;
import com.solvd.photostudio.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;


public class OrderRentalService {

    public OrderRental getOrderRentalById(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            OrderRentalMapper orderRentalMapper = sqlSession.getMapper(OrderRentalMapper.class);
            return orderRentalMapper.getOrderRentalById(id);
        }
    }

    public void insertOrderRental(OrderRental orderRental) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            OrderRentalMapper orderRentalMapper = sqlSession.getMapper(OrderRentalMapper.class);
            orderRentalMapper.saveOrderRental(orderRental);
            sqlSession.commit();
        }
    }

    public void updateOrderRental(OrderRental orderRental) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            OrderRentalMapper orderRentalMapper = sqlSession.getMapper(OrderRentalMapper.class);
            orderRentalMapper.updateOrderRental(orderRental);
            sqlSession.commit();
        }
    }

    public void deleteOrderRental(OrderRental orderRental) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            OrderRentalMapper orderRentalMapper = sqlSession.getMapper(OrderRentalMapper.class);
            orderRentalMapper.deleteOrderRental(orderRental);
            sqlSession.commit();
        }
    }

    public Map<Integer, OrderRental> getAllOrderRental() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            OrderRentalMapper orderRentalMapper = sqlSession.getMapper(OrderRentalMapper.class);
            return orderRentalMapper.getAllOrderRental();
        }
    }
}
