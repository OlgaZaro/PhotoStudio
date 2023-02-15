package com.solvd.photostudio.dao.jdbc;

import com.solvd.photostudio.dao.SubscriptionDao;
import com.solvd.photostudio.exception.DataProcessingException;
import com.solvd.photostudio.model.Subscription;
import com.solvd.photostudio.util.ConnectionUtil;

import java.sql.*;
import java.util.*;

import static com.solvd.photostudio.util.ConnectionUtil.closePrepareStatement;
import static com.solvd.photostudio.util.ConnectionUtil.getPrepareStatement;


public class SubscriptionDaoImpl implements SubscriptionDao {
    private PreparedStatement prepareStatement;

    public SubscriptionDaoImpl(String host, String name, String password) {
        new ConnectionUtil(host, name, password);
    }

    @Override
    public void insert(Subscription subscription) {
        try {
            prepareStatement = getPrepareStatement("INSERT INTO subscription "
                    + "(title, subscriptionPrice, customer_id) "
                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, subscription.getTitle());
            prepareStatement.setString(2, subscription.getSubscriptionPrice());
            prepareStatement.setInt(3, subscription.getCustomerId());
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(prepareStatement);
        }
    }

    @Override
    public Optional<Subscription> getById(Integer id) {
        try {
            prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM subscription WHERE id = ?");
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                Subscription subscription = getSubscriptionFromResultSet(result);
                closePrepareStatement(prepareStatement);
                System.out.println(Optional.of(subscription));
                return Optional.of(subscription);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get serviceOrder with ID " + id, e);
        }
    }

    @Override
    public List<Subscription> getAll() {
        List<Subscription> allSubscription = new ArrayList<>();
        try {
            prepareStatement = getPrepareStatement("SELECT * FROM subscription",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                Subscription subscription = getSubscriptionFromResultSet(result);
                allSubscription.add(subscription);
            }
            closePrepareStatement(prepareStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSubscription;
    }

    @Override
    public void update(Subscription subscription, int id) {
        try {
            prepareStatement = getPrepareStatement("UPDATE subscription SET orderPrice = ? ," +
                    " customerId = ? WHERE ID = ? ", Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, subscription.getTitle());
            prepareStatement.setString(2, subscription.getSubscriptionPrice());
            prepareStatement.setInt(3, subscription.getCustomerId());
            prepareStatement.setInt(4, id);
            prepareStatement.executeUpdate();
            System.out.println(prepareStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(prepareStatement);
        }
    }

    @Override
    public void delete(int id) {
        try {
            prepareStatement = getPrepareStatement("DELETE FROM subscription " + "WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(prepareStatement);
        }
    }

    private Subscription getSubscriptionFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String subscriptionPrice = resultSet.getString("subscriptionPrice");
        int customerId = resultSet.getInt("customer_id");
        Subscription subscription = new Subscription(id, title, subscriptionPrice, customerId);
        subscription.setId(id);
        return subscription;
    }
}