package com.example.demo2;

import java.util.List;
import java.util.ArrayList;

import com.example.demo2.Models.*;

import java.sql.*;

public class PostGradDAO {
    private String url = "jdbc:postgresql://localhost:5432/chinook";
    private String username = "postgres";
    private String password = "Klezzpatch2022";

    public PostGradDAO() {
        System.out.println("CreatedObject");

    }

    public PostGradDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void test() {
        System.out.println("testing");
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            System.out.println("Connected to Postgres...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllActors() {
        String sql = "SELECT * FROM actor";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<Customer>();

        String sql = "SELECT * FROM customer";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                Customer c = new Customer(
                        r.getInt("customer_id"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("country"),
                        r.getString("postal_code"),
                        r.getString("phone"),
                        r.getString("email")
                );
                allCustomers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCustomers;
    }

    public Customer getSpecificCustomers(int id) {
        Customer customer = null;

        String sql = "SELECT * FROM customer WHERE customer_id = " + id;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                customer = new Customer(
                        r.getInt("customer_id"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("country"),
                        r.getString("postal_code"),
                        r.getString("phone"),
                        r.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public Customer getSpecificCustomerByName(String name) {
        Customer customer = null;
        print(name);
        String sql = "SELECT * FROM customer WHERE first_name = '" + name+"'";
        print(sql);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet r = statement.executeQuery();
            while (r.next()) {
                customer = new Customer(
                        r.getInt("customer_id"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("country"),
                        r.getString("postal_code"),
                        r.getString("phone"),
                        r.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public List<Customer> getCustomerPage(int limit, int offset) {
        List<Customer> allCustomers = new ArrayList<Customer>();

        String sql = "SELECT * FROM customer LIMIT ? OFFSET ? ";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            statement.setInt(1, limit);
            statement.setInt(2, offset);

            ResultSet r = statement.executeQuery();
            while (r.next()) {
                Customer c = new Customer(
                        r.getInt("customer_id"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("country"),
                        r.getString("postal_code"),
                        r.getString("phone"),
                        r.getString("email")
                );
                allCustomers.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCustomers;
    }

    public void insertCustomerIntoDatabase(Customer customer){

        String sql = "INSERT INTO customer (first_name, last_name, country, postal_code, phone, email) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";



        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement

            //statement.setInt(1, customer.getId());
            statement.setString(1,customer.getFirst_name());
            statement.setString(2,customer.getLast_name());
            statement.setString(3,customer.getCountry());
            statement.setString(4,customer.getPostal_code());
            statement.setString(5,customer.getPhone_number());
            statement.setString(6,customer.getEmail());

            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void UpdateExistingCustomerInDatabase(Customer customer){

        String sql = "UPDATE customer SET first_name = ?, last_name = ?, country = ?, postal_code = ?, phone = ?, email = ? WHERE customer_id =" + customer.getId();



        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement

            //statement.setInt(1, customer.getId());
            statement.setString(1,customer.getFirst_name());
            statement.setString(2,customer.getLast_name());
            statement.setString(3,customer.getCountry());
            statement.setString(4,customer.getPostal_code());
            statement.setString(5,customer.getPhone_number());
            statement.setString(6,customer.getEmail());
            //statement.setInt(7,customer.getId());

            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public CountryCount TheMostCustomerCountry(){

        return null;
    }




    private static void print(String s) {
        System.out.println(s);
    }


}
