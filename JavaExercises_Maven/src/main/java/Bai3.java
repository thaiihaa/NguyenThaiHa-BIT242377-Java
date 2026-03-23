import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
}

public class Bai3 {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee(1, "Binh", 1200),
            new Employee(2, "An", 800),
            new Employee(3, "Dung", 1500),
            new Employee(4, "Chien", 950)
        );

        // Stream xu ly logic
        List<String> result = list.stream()
            .filter(e -> e.getSalary() > 1000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Nhan vien luong > 1000 (sap xep): " + result);
    }
}