
//Создадим класс Employee или використовуем тот, что мы создали для уроков по Stream API.
// настройка класса обслуживания, который бы контролировал связь этого класса с таблицей в базе данных:
// вставки новых сотрудников, редактирование данных обнаружения, удаление операций,
// чтение одного сотрудника по айди, чтение списка сотрудников по какому-либо фильтру.




public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    // Конструктор класса
    public Employee(int id, String name, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
