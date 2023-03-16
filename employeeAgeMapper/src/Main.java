import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Employee> employees = Arrays.asList(
                new Employee(25),
                new Employee(30),
                new Employee(33),
                new Employee(42),
                new Employee(28),
                new Employee(31),
                new Employee(39),
                new Employee(22),
                new Employee(27),
                new Employee(35)
        );

        Map<String, Integer> ageMap = EmployeeAgeMapper.mapByAgeRange(employees);
        System.out.println(ageMap);

        Map<String, Double> agePercentageMap = EmployeeAgeMapper.mapByAgeRangePercentage(employees);
        System.out.println(agePercentageMap);



    }
}