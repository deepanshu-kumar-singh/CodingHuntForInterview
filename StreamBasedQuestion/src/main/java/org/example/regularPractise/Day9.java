package org.example.regularPractise;

import java.util.*;
import java.util.stream.Collectors;

public class Day9 {
    public static void main(String[] args) {
/*        1️⃣ Group employees by department and sort by salary (desc) inside each department.
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

        Map<String, List<Employee>> collect = emp.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(collect);

        Map<String, Optional<Employee>> collect1 = emp.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(collect1);

        Map<String, Double> collect2 = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect2);

        Map<String, Long> collect3 = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(collect3);
    }
}
