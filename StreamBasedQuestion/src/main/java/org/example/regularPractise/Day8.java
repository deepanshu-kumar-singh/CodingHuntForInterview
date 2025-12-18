package org.example.regularPractise;

import java.util.*;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) {
        List<Employees> emp = Arrays.asList(
                new Employees("Ceepu", "Developer", 1000),
                new Employees("Feepu", "Developer", 2000),
                new Employees("Deepu", "Developer", 3000),
                new Employees("Aeepu", "Deveops", 1500),
                new Employees("Beepu", "Deveops", 2500),
                new Employees("Seepu", "Deveops", 3500),
                new Employees("Rahul", "Hr", 500),
                new Employees("Reenu", "Hr", 550),
                new Employees("Ritu", "Hr", 600)
        );

        //1️⃣ Group employees by department
        Map<String, List<Employees>> collect =
                emp.stream().collect(Collectors.groupingBy(Employees::getDept));
        System.out.println(collect);

        //Count employees in each department
        Map<String, Long> collect1 = emp
                .stream()
                .collect(Collectors.groupingBy(Employees::getDept, Collectors.counting()));
        System.out.println(collect1);

        //Find highest paid employee
        Employees employees = emp.stream()
                .max(Comparator.comparingInt(Employees::getSalary)).get();
        System.out.println(employees);

        //4️⃣ Find highest paid employee in each department
        Map<String, Optional<Employees>> collect2 = emp.stream()
                .collect(Collectors.groupingBy(Employees::getDept,
                        Collectors.maxBy(Comparator.comparing(Employees::getSalary))));
        System.out.println(collect2);

        //5️⃣ Find average salary of employees
        Double collect3 = emp.stream().collect(Collectors.averagingDouble(Employees::getSalary));
        System.out.println(collect3);

    }
}
