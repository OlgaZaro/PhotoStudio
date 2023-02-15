package com.solvd.photostudio.mybatis.mybatisservise;

import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.mybatis.mapper.CustomerMapper;
import com.solvd.photostudio.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;


public class CustomerService {

    public Customer getCustomerById(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            return customerMapper.getCustomerById(id);
        }
    }

    public static void insertCustomer(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.saveCustomer(customer);
            sqlSession.commit();
        }
    }

    public void updateCustomer(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updateCustomer(customer);
            sqlSession.commit();
        }
    }

    public void deleteCustomer(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.deleteCustomer(customer);
            sqlSession.commit();
        }
    }

    public Map<Integer, Customer> getAllCustomer() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            return customerMapper.getAllCustomer();
        }
    }
}
