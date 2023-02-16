package com.solvd.photostudio.dao.jdbc;

import com.solvd.photostudio.dao.CustomerDao;
import com.solvd.photostudio.exception.DataProcessingException;
import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.util.ConnectionUtil;

import java.sql.*;
import java.util.*;


public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl(String host, String name, String password) {
        new ConnectionUtil(host, name, password);
    }

    @Override
    public void insert(Customer customer) {
        String insertUserQuery = "INSERT INTO customer (id, firstName, lastName, phone, mail) VALUES (?,?,?,?,?)";

        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement(insertUserQuery,
                    Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, customer.getId());
            prepareStatement.setString(2, customer.getFirstName());
            prepareStatement.setString(3, customer.getLastName());
            prepareStatement.setString(4, customer.getPhone());
            prepareStatement.setString(5, customer.getMail());
            prepareStatement.execute();
            try (ResultSet resultSet = prepareStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    customer.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to create " + customer, e);
        }
    }

    @Override
    public Optional<Customer> getById(Integer id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM customer WHERE id = ?")) {
            prepareStatement.setInt(1, id);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                Customer customer = getCustomerFromResultSet(result);
                System.out.println(Optional.of(customer));
                return Optional.of(customer);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get customer with ID " + id, e);
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> allCustomers = new ArrayList<>();
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM customer",
                    Statement.RETURN_GENERATED_KEYS)) {
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                Customer customer = getCustomerFromResultSet(result);
                allCustomers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

    @Override
    public void update(Customer customer, int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("UPDATE customer SET firstName = ? ," +
                    " lastName = ? , phone = ?, mail = ? WHERE ID = ? ", Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, customer.getFirstName());
            prepareStatement.setString(2, customer.getLastName());
            prepareStatement.setString(3, customer.getPhone());
            prepareStatement.setString(4, customer.getMail());
            prepareStatement.setInt(5, id);
            prepareStatement.executeUpdate();
            System.out.println(prepareStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("DELETE FROM customer " + "WHERE id = ?",
                    Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, id);
            prepareStatement.execute();
            System.out.println(prepareStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> findByLastName(String lastName){
        try ( PreparedStatement prepareStatement = ConnectionUtil.getPrepareStatement("SELECT * FROM customer WHERE lastName = ?")) {
            prepareStatement.setString(1, lastName);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                Customer customer = getCustomerFromResultSet(result);
                System.out.println(Optional.of(customer));
                return Optional.of(customer);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Unable to get customer with lastName " + lastName, e);
        }
    }

    private Customer getCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String phone = resultSet.getString("phone");
        String mail = resultSet.getString("mail");
        Customer customer = new Customer(firstName, lastName, phone, mail);
        customer.setId(id);
        return customer;
    }
}