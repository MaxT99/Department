package app.repository;

import app.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static final String SELECT_ALL_QUERY = "SELECT * FROM employees";
    public static final String SELECT_ONE_QUERY = "SELECT * FROM employees WHERE id=?";
    public static final String SELECT_DEPID_QUERY = "SELECT * FROM employees WHERE depId=?";
    public static final String INSERT_QUERY = "INSERT INTO employees (firstname , lastname , age , phone , email , position , depId) Values (?,?,?,?,?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE employees SET firstname = ?, lastname = ?, age = ?, phone = ?, email = ?, position = ?, depId= ? WHERE id = ?";
    public static final String DELETE_QUERY = "DELETE FROM employees WHERE id = ?";

    private static String DB_URL = "jdbc:mysql://localhost:3306/DepartmentDB";
    private static String DB_USER = "root";
    private static String DB_PASS = "r07022012";

    public EmployeeRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Employee> findAllEmployees() {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String age = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String position = resultSet.getString(7);
                int depId = resultSet.getInt(8);

                Employee employee = new Employee(id, firstname, lastname, age, phone, email, position, depId);
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("findAll: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return employees;
    }

    public Employee findById(int id) {

        Employee employee = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ONE_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int empId = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String age = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String position = resultSet.getString(7);
                int depId = resultSet.getInt(8);

                employee = new Employee(empId, firstname, lastname, age, phone, email, position, depId);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
        return employee;
    }

    public List<Employee> findByDepId(int depId) {

        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_DEPID_QUERY);
            preparedStatement.setInt(1, depId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String age = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                String position = resultSet.getString(7);
                int deptId = resultSet.getInt(8);

                employees.add(new Employee(id , firstname, lastname, age, phone, email, position, deptId));
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
        return employees;
    }


    public int create(Employee employee) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)){
            try (PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY)) {
                preparedStatement.setString(1, employee.getFirstname());
                preparedStatement.setString(2, employee.getLastname());
                preparedStatement.setString(3, employee.getAge());
                preparedStatement.setString(4, employee.getPhone());
                preparedStatement.setString(5, employee.getEmail());
                preparedStatement.setString(6, employee.getPosition());
                preparedStatement.setInt(7, employee.getDepId());
                return Integer.parseInt(String.valueOf(preparedStatement.executeUpdate()));
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new RuntimeException(ex);
        }
    }

    public int update(Employee employee) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getAge());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setString(6, employee.getPosition());
            preparedStatement.setInt(7, employee.getDepId());
            preparedStatement.setInt(8, employee.getId());
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


