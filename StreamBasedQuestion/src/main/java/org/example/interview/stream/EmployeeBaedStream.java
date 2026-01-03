package org.example.interview.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeBaedStream {
    public static void main(String[] args) {

        List<Employee> emp = Arrays.asList(
                new Employee("Ceepu", "Developer", 1000),
                new Employee("Feepu", "Developer", 2000),
                new Employee("Deepu", "Developer", 3000),
                new Employee("rtyu", "Developer", 3000),
                new Employee("Aeepu", "Deveops", 1500),
                new Employee("Beepu", "Deveops", 2500),
                new Employee("Seepu", "Deveops", 3500),
                new Employee("Rahul", "Hr", 500),
                new Employee("Reenu", "Hr", 550),
                new Employee("Ritu", "Hr", 600)
        );
//        //1️⃣ Highest Paid Employee
        Employee employee = emp.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst()
                .get();
        System.out.println(employee);

//        2️⃣ Second Highest Salary Employee
        Employee employee1 = emp.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(employee1);
//        3️⃣ Highest Paid Employee in Each Department
        Map<String, Optional<Employee>> collect = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect);
//        4️⃣ Average Salary by Department
        Map<String, Double> collect1 = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect1);
//        5️⃣ Count Employees in Each Department
        Map<String, Long> collect2 = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(collect2);
//        6️⃣ Department with Maximum Employees
        String string = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(string);

        List<String> words = List.of("1apple", "banana", "2apple", "cat", "banana", "apple");

        List<String> list = words.stream().filter(x -> Character.isDigit(x.charAt(0))).toList();
        System.out.println(list);

        List<Integer> num= Arrays.asList(2,6,7,11,5,77,67,2);
        List<Integer> nums= Arrays.asList(5,77,67,2);
        List<Integer> list1 = num.stream().filter(nums::contains).toList();
        System.out.println(list1);

        String str =  "sweeden";
        Map<String, Long> collect3 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect3);
        Optional<Map.Entry<String, Long>> first = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .findFirst();
        System.out.println(first);

    }

}

class Employee {
    private String name;
    private String dept;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;

    }
}