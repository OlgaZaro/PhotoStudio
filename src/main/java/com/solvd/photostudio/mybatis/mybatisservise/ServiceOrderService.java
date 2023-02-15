package com.solvd.photostudio.mybatis.mybatisservise;

import com.solvd.photostudio.model.ServiceOrder;
import com.solvd.photostudio.mybatis.mapper.ServiceOrderMapper;
import com.solvd.photostudio.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;


public class ServiceOrderService {

    public ServiceOrder getServiceOrderById(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ServiceOrderMapper serviceOrderMapper = sqlSession.getMapper(ServiceOrderMapper.class);
            return serviceOrderMapper.getServiceOrderById(id);
        }
    }

    public void insertServiceOrder(ServiceOrder serviceOrder) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ServiceOrderMapper serviceOrderMapper = sqlSession.getMapper(ServiceOrderMapper.class);
            serviceOrderMapper.saveServiceOrder(serviceOrder);
            sqlSession.commit();
        }
    }

    public void updateServiceOrder(ServiceOrder serviceOrder) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ServiceOrderMapper serviceOrderMapper = sqlSession.getMapper(ServiceOrderMapper.class);
            serviceOrderMapper.updateServiceOrder(serviceOrder);
            sqlSession.commit();
        }
    }

    public void deleteServiceOrder(ServiceOrder serviceOrder) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ServiceOrderMapper serviceOrderMapper = sqlSession.getMapper(ServiceOrderMapper.class);
            serviceOrderMapper.deleteServiceOrder(serviceOrder);
            sqlSession.commit();
        }
    }

    public Map<Integer, ServiceOrder> getAllServiceOrder() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ServiceOrderMapper serviceOrderMapper = sqlSession.getMapper(ServiceOrderMapper.class);
            return serviceOrderMapper.getAllServiceOrder();
        }
    }
}
