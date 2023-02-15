package com.solvd.photostudio.mybatis.mybatisservise;

import com.solvd.photostudio.model.Subscription;
import com.solvd.photostudio.mybatis.mapper.SubscriptionMapper;
import com.solvd.photostudio.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;


public class SubscriptionService {

    public Subscription getSubscriptionById(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            SubscriptionMapper subscriptionMapper = sqlSession.getMapper(SubscriptionMapper.class);
            return subscriptionMapper.getSubscriptionById(id);
        }
    }

    public void insertSubscription(Subscription subscription) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            SubscriptionMapper subscriptionMapper = sqlSession.getMapper(SubscriptionMapper.class);
            subscriptionMapper.saveSubscription(subscription);
            sqlSession.commit();
        }
    }

    public void updateSubscription(Subscription subscription) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            SubscriptionMapper subscriptionMapper = sqlSession.getMapper(SubscriptionMapper.class);
            subscriptionMapper.updateSubscription(subscription);
            sqlSession.commit();
        }
    }

    public void deleteSubscription(Subscription subscription) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            SubscriptionMapper subscriptionMapper = sqlSession.getMapper(SubscriptionMapper.class);
            subscriptionMapper.deleteSubscription(subscription);
            sqlSession.commit();
        }
    }

    public Map<Integer, Subscription> getAllSubscription() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            SubscriptionMapper subscriptionMapper = sqlSession.getMapper(SubscriptionMapper.class);
            return subscriptionMapper.getAllSubscription();
        }
    }
}
