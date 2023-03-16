import java.util.*;

public class Employee {
   // Создайте метод, который будет принимать коллекцию с сотрудниками
    // (можно использовать класс Employee с урока, только создайте чуть больше объектов) и на выходе выдавать мапу где ключом будет должность сотрудника, а значением
    // - средняя заработная плата на этой должности

    private String name;
    private String position;
    private int salary;

    public Employee(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public static Map<String, Double> averageSalaryByPosition(Collection<Employee> employees) {
        Map<String, Double> result = new HashMap<>();

        Map<String, List<Employee>> employeesByPosition = new HashMap<>();
        for (Employee employee : employees) {
            String position = employee.getPosition();
            if (!employeesByPosition.containsKey(position)) {
                employeesByPosition.put(position, new ArrayList<>());
            }
            employeesByPosition.get(position).add(employee);
        }

        for (Map.Entry<String, List<Employee>> entry : employeesByPosition.entrySet()) {
            String position = entry.getKey();
            List<Employee> employeesWithPosition = entry.getValue();

            double totalSalary = 0.0;
            for (Employee employee : employeesWithPosition) {
                totalSalary += employee.getSalary();
            }

            double averageSalary = totalSalary / employeesWithPosition.size();
            result.put(position, averageSalary);
        }

        return result;
    }

    public static void main(String[] args) {
        Collection<Employee> employees = Arrays.asList(
                new Employee("John", "Manager", 5000),
                new Employee("Mary", "Developer", 4000),
                new Employee("Jane", "Developer", 4500),
                new Employee("Bob", "Manager", 5500),
                new Employee("Alice", "Developer", 4200)
        );

        Map<String, Double> averageSalaryByPosition = averageSalaryByPosition(employees);

        for (Map.Entry<String, Double> entry : averageSalaryByPosition.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
//В методе averageSalaryByPosition мы создаем пустую мапу result,
// затем создаем еще одну мапу employeesByPosition, где ключом является должность,
// а значением - список сотрудников на этой должности. Затем мы проходимся по всем сотрудникам из переданной коллекции,
// добавляем их в соответствующие списки в employeesByPosition. После этого мы проходимся по всем записям в employeesByPosition и
// вычисляем среднюю заработную плату для каждой должности. Результат записываем в result. В конце метода мы возвращаем result.
//
//В методе main мы создаем некоторое количество сотрудников и передаем их в метод averageSalaryByPosition.
// Затем мы выводим результат на консоль.
