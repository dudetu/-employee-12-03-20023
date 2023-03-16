
import java.util.*;

public class EmployeeAgeMapper {
    //Создайте метод, который будет принимать коллекцию с сотрудниками и на выходе выдавать мапу,
    // где ключами будут отрезки возрастов по 10 лет, типа 20 - 30, 30 - 40 и тп,
    // а значением количество сотрудников в этом возрастном диапазоне. Можно еще одну вариацию,
    // в значение посчитать долю сотрудников в этом возрасте относительно всех сотрудников

    public static Map<String, Integer> mapByAgeRange(Collection<Employee> employees) {
        Map<String, Integer> ageMap = new TreeMap<>();

        for (Employee employee : employees) {
            int age = employee.getAge();
            String range = getAgeRange(age);

            ageMap.put(range, ageMap.getOrDefault(range, 0) + 1);
        }

        return ageMap;
    }

    public static Map<String, Double> mapByAgeRangePercentage(Collection<Employee> employees) {
        Map<String, Double> ageMap = new TreeMap<>();
        int totalEmployees = employees.size();

        for (Employee employee : employees) {
            int age = employee.getAge();
            String range = getAgeRange(age);
            double percentage = 1.0 / totalEmployees * 100;

            ageMap.put(range, ageMap.getOrDefault(range, 0.0) + percentage);
        }

        return ageMap;
    }

    private static String getAgeRange(int age) {
        int rangeStart = age / 10 * 10;
        int rangeEnd = rangeStart + 9;

        return rangeStart + " - " + rangeEnd;
    }
}

class Employee {
    private int age;

    public Employee(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
