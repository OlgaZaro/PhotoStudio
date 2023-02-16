package com.solvd.photostudio.dao.jdbc;

import com.solvd.photostudio.dao.GiftCertificateDao;
import com.solvd.photostudio.exception.DataProcessingException;
import com.solvd.photostudio.model.GiftCertificate;
import com.solvd.photostudio.util.ConnectionUtil;

import java.sql.*;
import java.util.*;


public class GiftCertificateDaoImpl implements GiftCertificateDao {

    public GiftCertificateDaoImpl(String host, String name, String password) {
        new ConnectionUtil(host, name, password);
    }

    @Override
    public void insert(GiftCertificate giftCertificate) {

        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("INSERT INTO giftCertificate "
                    + "(certificatePrice, serviceOrder_id) "
                    + "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)){
            prepareStatement.setString(1, giftCertificate.getCertificatePrice());
            prepareStatement.setInt(2, giftCertificate.getServiceOrderId());
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<GiftCertificate> getById(Integer id) {

        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM giftCertificate WHERE id = ?")) {
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                GiftCertificate giftCertificate = getGiftCertificateFromResultSet(result);
                System.out.println(Optional.of(giftCertificate));
                return Optional.of(giftCertificate);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get giftCertificate with ID " + id, e);
        }
    }

    @Override
    public List<GiftCertificate> getAll() {

        List<GiftCertificate> allGiftCertificate = new ArrayList<>();
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM giftCertificate",
                    Statement.RETURN_GENERATED_KEYS)) {
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                GiftCertificate giftCertificate = getGiftCertificateFromResultSet(result);
                allGiftCertificate.add(giftCertificate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGiftCertificate;
    }

    @Override
    public void update(GiftCertificate giftCertificate, int id) {

        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("UPDATE giftCertificate SET certificatePrice = ? ," +
                    " ServiceOrderId = ? WHERE ID = ? ", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, giftCertificate.getCertificatePrice());
            prepareStatement.setInt(2, giftCertificate.getServiceOrderId());
            prepareStatement.setInt(3, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("DELETE FROM giftCertificate " + "WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private GiftCertificate getGiftCertificateFromResultSet(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String certificatePrice = resultSet.getString("certificatePrice");
        int serviceOrderId = resultSet.getInt("serviceOrder_id");
        GiftCertificate giftCertificate = new GiftCertificate(id, certificatePrice, serviceOrderId);
        giftCertificate.setId(id);
        return giftCertificate;
    }
}
