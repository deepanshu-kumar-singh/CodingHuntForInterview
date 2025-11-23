package org.example.regularPractise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) {
       /* 🧩 Grouping + Sorting + Mapping

        1️⃣ Group employees by department and sort by salary (desc) inside each department.
        2️⃣ Find highest salary employee per department → Map<String, Employee>
        3️⃣ Convert list of employees into → Map<Department, List<String>> (only names).
        4️⃣ Group transactions by Type and sum the total amount.
        5️⃣ Find average salary per department with averagingDouble.
        6️⃣ Count how many times each word appears → Map<String, Long>.
        7️⃣ Group people by dept and then count → Map<Integer, Long>.
        */

        List<Employee> emp = Arrays.asList(
                new Employee("Ceepu", "Developer", 1000),
                new Employee("Feepu", "Developer", 2000),
                new Employee("Deepu", "Developer", 3000),
                new Employee("Aeepu", "Deveops", 1500),
                new Employee("Beepu", "Deveops", 2500),
                new Employee("Seepu", "Deveops", 3500),
                new Employee("Rahul", "Hr", 500),
                new Employee("Reenu", "Hr", 550),
                new Employee("Ritu", "Hr", 600)
        );

        Map<String, List<Employee>> listMap = emp.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("Group employees by department and sort by salary" + listMap);

        Map<String, Optional<Employee>> maxSalary = emp.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDept, Collectors.maxBy(
                                        Comparator.comparingInt(Employee::getSalary))));
        System.out.println("highest salary employee per department" + maxSalary);

        Map<String, List<String>> collect = emp.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("list of employees into → Map<Department, List<String>>" + collect);

        Map<String, Double> collect1 = emp.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Find average salary per department with averagingDouble"+ collect1);

        Map<String, Long> collect2 = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println("Group people by dept and then count :"+ collect2);

   /*
      11️⃣ Find second highest salary using Streams.
        12️⃣ Find employee with longest name per department.
        13️⃣ Reduce list of integers into a comma-separated string.
        14️⃣ Find max occurring character in a string.
    */

        Optional<Employee> first = emp.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst();
        System.out.println("second highest salary"+first.get());

        Map<String, Optional<Employee>> collect3 = emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(Employee::getName))));
        System.out.println("Find employee with longest name per department."+ collect3);

        String s = "sweeddeen";
        String key = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
        System.out.println(key);

        String collect4 = Arrays.stream(s.split("")).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect4);


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