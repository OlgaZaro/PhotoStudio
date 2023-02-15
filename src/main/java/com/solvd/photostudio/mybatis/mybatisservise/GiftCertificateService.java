package com.solvd.photostudio.mybatis.mybatisservise;

import com.solvd.photostudio.model.GiftCertificate;
import com.solvd.photostudio.mybatis.mapper.GiftCertificateMapper;
import com.solvd.photostudio.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;


public class GiftCertificateService {

    public GiftCertificate getGiftCertificateById(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GiftCertificateMapper giftCertificateMapper = sqlSession.getMapper(GiftCertificateMapper.class);
            return giftCertificateMapper.getGiftCertificateById(id);
        }
    }

    public void insertGiftCertificate(GiftCertificate giftCertificate) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GiftCertificateMapper giftCertificateMapper = sqlSession.getMapper(GiftCertificateMapper.class);
            giftCertificateMapper.saveGiftCertificate(giftCertificate);
            sqlSession.commit();
        }
    }

    public void updateGiftCertificate(GiftCertificate giftCertificate) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GiftCertificateMapper giftCertificateMapper = sqlSession.getMapper(GiftCertificateMapper.class);
            giftCertificateMapper.updateGiftCertificate(giftCertificate);
            sqlSession.commit();
        }
    }

    public void deleteGiftCertificate(GiftCertificate giftCertificate) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GiftCertificateMapper giftCertificateMapper = sqlSession.getMapper(GiftCertificateMapper.class);
            giftCertificateMapper.deleteGiftCertificate(giftCertificate);
            sqlSession.commit();
        }
    }

    public Map<Integer, GiftCertificate> getAllGiftCertificate() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            GiftCertificateMapper giftCertificateMapper = sqlSession.getMapper(GiftCertificateMapper.class);
            return giftCertificateMapper.getAllGiftCertificate();
        }
    }
}
