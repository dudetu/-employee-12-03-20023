import java.util.*;

public class EmployeeAgeRange {

  //Создайте метод, который будет принимать коллекцию с сотрудниками и на выходе выдавать мапу,
  // где ключами будут отрезки возрастов по 10 лет, типа 20 - 30, 30 - 40 и тп,
  // а значением количество сотрудников в этом возрастном диапазоне.
  // Можно еще одну вариацию, в значение посчитать долю
  // сотрудников в этом возрасте относительно всех сотрудников

  //Вот пример кода , который реализует метод, который принимает коллекцию
  // сотрудников и возвращает мапу с возрастными диапазонами в качестве ключей и
  // количеством сотрудников или долей относительно общего числа сотрудников в качестве значений:

    //Класс EmployeeAgeRange содержит два статических метода: getAgeRangeCounts и getAgeRangeRatios.
    // Оба метода принимают коллекцию объектов Employee и возвращают мапу, где ключами являются возрастные диапазоны,
    // а значениями - количество сотрудников или доля сотрудников в этом диапазоне.
    //
    //Метод getAgeRangeCounts просто перебирает сотрудников в коллекции, вычисляет их возрастные диапазоны

    public static Map<String, Integer> getAgeRangeCounts(Collection<Employee> employees) {
        Map<String, Integer> ageRangeCounts = new HashMap<>();
        for (Employee employee : employees) {
            int age = employee.getAge();
            String ageRange = getAgeRange(age);
            ageRangeCounts.put(ageRange, ageRangeCounts.getOrDefault(ageRange, 0) + 1);
        }
        return ageRangeCounts;
    }

    public static Map<String, Double> getAgeRangeRatios(Collection<Employee> employees) {
        Map<String, Double> ageRangeRatios = new HashMap<>();
        int totalEmployees = employees.size();
        for (Map.Entry<String, Integer> entry : getAgeRangeCounts(employees).entrySet()) {
            String ageRange = entry.getKey();
            int count = entry.getValue();
            double ratio = ((double) count) / totalEmployees;
            ageRangeRatios.put(ageRange, ratio);
        }
        return ageRangeRatios;
    }

    private static String getAgeRange(int age) {
        int minAge = (age / 10) * 10;
        int maxAge = minAge + 9;
        return String.format("%d - %d", minAge, maxAge);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 28),
                new Employee("Mary", 32),
                new Employee("Mike", 44),
                new Employee("Alice", 25),
                new Employee("Bob", 37),
                new Employee("Jane", 19),
                new Employee("David", 56),
                new Employee("Sara", 22),
                new Employee("Mark", 30),
                new Employee("Karen", 40)
        );
        Map<String, Integer> ageRangeCounts = getAgeRangeCounts(employees);
        System.out.println("Age range counts: " + ageRangeCounts);
        Map<String, Double> ageRangeRatios = getAgeRangeRatios(employees);
        System.out.println("Age range ratios: " + ageRangeRatios);
    }

    private static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }
}

