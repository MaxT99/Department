package app.repository;


import app.model.Department;

import java.sql.*;
import java.util.ArrayList;

public class DepartmentRepository {
    // TODO: rename table name departments -> department
    public static final String SELECT_ALL_QUERY = "SELECT * FROM departments";
    public static final String SELECT_ONE_QUERY = "SELECT * FROM departments WHERE id=?";
    public static final String INSERT_QUERY = "INSERT INTO departments (name, phone, email, address, description) Values (?,?,?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE departments SET name = ?, phone = ?, email = ?, address = ?, description = ? WHERE id = ?";
    public static final String DELETE_QUERY = "DELETE FROM departments WHERE id = ?";

    // TODO: DepartmentDB -> my_department
    private static String DB_URL = "jdbc:mysql://localhost:3306/DepartmentDB";
    private static String DB_USER = "root";
    private static String DB_PASS = "r07022012";

    public DepartmentRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Department> findAll() {
        ArrayList<Department> departments = new ArrayList<Department>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String email = resultSet.getString(4);
                String address = resultSet.getString(5);
                String description = resultSet.getString(6);
                Department department = new Department(id, name, phone, email, address, description);
                departments.add(department);
            }
        } catch (SQLException e) {
            System.out.println("findAll: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return departments;
    }

    public Department findById(int id) {

        Department department = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ONE_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int prodId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String email = resultSet.getString(4);
                String address = resultSet.getString(5);
                String description = resultSet.getString(6);
                department = new Department(prodId, name, phone, email, address, description);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
        return department;
    }

    public int create(Department department) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            try (PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setString(1, department.getName());
                preparedStatement.setString(2, department.getPhone());
                preparedStatement.setString(3, department.getEmail());
                preparedStatement.setString(4, department.getAddress());
                preparedStatement.setString(5, department.getDescription());

                return Integer.parseInt(String.valueOf(preparedStatement.executeUpdate()));
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }

    public int update(Department department) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getPhone());
            preparedStatement.setString(3, department.getEmail());
            preparedStatement.setString(4, department.getAddress());
            preparedStatement.setString(5, department.getDescription());
            preparedStatement.setInt(6, department.getId());
            return Integer.parseInt(String.valueOf(preparedStatement.executeUpdate()));
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }

    public int delete(int id) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);

            return Integer.parseInt(String.valueOf(preparedStatement.executeUpdate()));

        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }
}
