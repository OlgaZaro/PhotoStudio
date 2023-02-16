package com.solvd.photostudio.dao.jdbc;

import com.solvd.photostudio.dao.OrderRentalDao;
import com.solvd.photostudio.exception.DataProcessingException;
import com.solvd.photostudio.model.OrderRental;
import com.solvd.photostudio.util.ConnectionUtil;

import java.sql.*;
import java.util.*;


public class OrderRentalDaoImpl implements OrderRentalDao {

    public OrderRentalDaoImpl(String host, String name, String password) {
        new ConnectionUtil(host, name, password);
    }

    @Override
    public void insert(OrderRental orderRental) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("INSERT INTO orderRental "
                    + "(orderPrice, customer_id) "
                    + "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, orderRental.getOrderPrice());
            prepareStatement.setInt(2, orderRental.getCustomerId());
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<OrderRental> getById(Integer id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM orderRental WHERE id = ?")) {
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                OrderRental orderRental = getOrderRentalFromResultSet(result);
                System.out.println(Optional.of(orderRental));
                return Optional.of(orderRental);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get orderRental with ID " + id, e);
        }
    }

    @Override
    public List<OrderRental> getAll() {
        List<OrderRental> allOrderRental = new ArrayList<>();
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM orderRental",
                    Statement.RETURN_GENERATED_KEYS)) {
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                OrderRental orderRental = getOrderRentalFromResultSet(result);
                allOrderRental.add(orderRental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOrderRental;
    }

    @Override
    public void update(OrderRental orderRental, int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("UPDATE orderRental SET orderPrice = ? ," +
                    " customerId = ? WHERE ID = ? ", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, orderRental.getOrderPrice());
            prepareStatement.setInt(2, orderRental.getCustomerId());
            prepareStatement.setInt(3, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("DELETE FROM orderRental " +
                    "WHERE id = ?", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private OrderRental getOrderRentalFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String orderPrice = resultSet.getString("orderPrice");
        int customerId = resultSet.getInt("customer_id");
        OrderRental orderRental = new OrderRental(id, orderPrice, customerId);
        orderRental.setId(id);
        return orderRental;
    }
}