package com.solvd.photostudio.dao.jdbc;

import com.solvd.photostudio.dao.ServiceOrderDao;
import com.solvd.photostudio.exception.DataProcessingException;
import com.solvd.photostudio.model.ServiceOrder;
import com.solvd.photostudio.util.ConnectionUtil;

import java.sql.*;
import java.util.*;


public class ServiceOrderDaoImpl implements ServiceOrderDao {

    public ServiceOrderDaoImpl(String host, String name, String password) {
        new ConnectionUtil(host, name, password);
    }

    @Override
    public void insert(ServiceOrder serviceOrder) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("INSERT INTO serviceOrder "
                + "(orderPrice, customer_id) "
                + "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, serviceOrder.getOrderPrice());
            prepareStatement.setInt(2, serviceOrder.getCustomerId());
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ServiceOrder> getById(Integer id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM serviceOrder WHERE id = ?")) {
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                ServiceOrder serviceOrder = getServiceOrderFromResultSet(result);
                System.out.println(Optional.of(serviceOrder));
                return Optional.of(serviceOrder);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get serviceOrder with ID " + id, e);
        }
    }

    @Override
    public List<ServiceOrder> getAll() {
        List<ServiceOrder> allServiceOrder = new ArrayList<>();
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM serviceOrder",
                Statement.RETURN_GENERATED_KEYS)) {
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                ServiceOrder serviceOrder = getServiceOrderFromResultSet(result);
                allServiceOrder.add(serviceOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allServiceOrder;
    }

    @Override
    public void update(ServiceOrder serviceOrder, int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("UPDATE serviceOrder SET orderPrice = ? ," +
                " customerId = ? WHERE ID = ? ", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, serviceOrder.getOrderPrice());
            prepareStatement.setInt(2, serviceOrder.getCustomerId());
            prepareStatement.setInt(3, id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("DELETE FROM serviceOrder " +
                "WHERE id = ?", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ServiceOrder getServiceOrderFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String orderPrice = resultSet.getString("orderPrice");
        int customerId = resultSet.getInt("customer_id");
        ServiceOrder serviceOrder = new ServiceOrder(id, orderPrice, customerId);
        serviceOrder.setId(id);
        return serviceOrder;
    }
}