import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Collection<Employee> employees = Arrays.asList(
                new Employee("John Doe", "Manager"),
                new Employee("Jane Smith", "Developer"),
                new Employee("Bob Johnson", "Developer"),
                new Employee("Alice Lee", "Manager")
        );

        Map<String, Integer> employeeCountByPosition = Employee.countEmployeesByPosition(employees);

        for (Map.Entry<String, Integer> entry : employeeCountByPosition.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }}
//В этом коде мы создали класс Employee, представляющий сотрудника с двумя полями: name (имя) и position (должность).
// Затем мы создали статический метод countEmployeesByPosition,
// который принимает коллекцию employees с сотрудниками и возвращает мапу, содержащую количество сотрудников в каждой должности.
//
//Для каждого сотрудника мы получаем должность и проверяем,
// существует ли уже запись для этой должности в мапе.
// Если запись существует, мы увеличиваем соответствующее значение на 1, в противном случае мы
// создаем новую запись в мапе с начальным значением 1.
// В конце мы возвращаем мапу с количеством сотрудников по должностям.
//
//В методе main мы создали некоторых сотрудников и передали их в метод countEmployeesByPosition. Затем мы распечатали результат, используя цикл for и метод entrySet() для перебора всех записей в мапе.