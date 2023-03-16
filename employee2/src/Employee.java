import java.util.*;

public class Employee {
    //Создайте метод, который будет принимать коллекцию с сотрудниками и на выходе выдавать мапу, где ключом будет должность,
    // а значением количество сотрудников, работающих в этой должности. На Джава
    //Конечный результат, который мы хотим получить, представляет собой мапу с ключами, представляющими должности,
    // и значениями, представляющими количество сотрудников, работающих в каждой должности. Мы можем создать метод,
    // который принимает коллекцию сотрудников и возвращает мапу,
    // используя следующий код

    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public static Map<String, Integer> countEmployeesByPosition(Collection<Employee> employees) {
        Map<String, Integer> result = new HashMap<>();
        for (Employee employee : employees) {
            String position = employee.getPosition();
            if (result.containsKey(position)) {
                result.put(position, result.get(position) + 1);
            } else {
                result.put(position, 1);
            }
        }
        return result;
    }


    }


