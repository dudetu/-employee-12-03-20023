import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private Connection connection;

    // Конструктор класса
    public EmployeeService(Connection connection) {
        this.connection = connection;
    }

    // Метод для вставки нового сотрудника в базу данных
    public void insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (name, age, department, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());
        statement.setString(3, employee.getDepartment());
        statement.setDouble(4, employee.getSalary());
        statement.executeUpdate();
    }

    // Метод для обновления данных о сотруднике
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name=?, age=?, department=?, salary=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());
        statement.setString(3, employee.getDepartment());
        statement.setDouble(4, employee.getSalary());
        statement.setInt(5, employee.getId());
        statement.executeUpdate();
    }

    // Метод для удаления сотрудника из базы данных по id
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    // Метод для чтения одного сотрудника по id
    public Employee getEmployeeById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String department = resultSet.getString("department");
            double salary = resultSet.getDouble("salary");
            return new Employee(id, name, age, department, salary);
        } else {
            return null;
        }
    }

    public List<Employee> getEmployeesByFilter(String age, int i) {
        return null;
    }


    //Этот класс можно использовать для работыEmployeeService и
    // передать ему соединение с базой данных. Например:
   // Создаем соединение с базой данных
  //  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root");
}

