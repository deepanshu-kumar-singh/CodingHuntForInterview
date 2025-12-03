package org.example.regularPractise;

import java.util.*;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) {
      /*
       2️⃣ Convert a list of strings to uppercase

       */
        List<String> words = List.of("4apple", "1bananaana", "apple", "cat", "banana", "apple");
        List<Integer> num = Arrays.asList(2, 6, 7, 11, 6, 7, 5, 77, 67, 2);
        List<Integer> num1 = Arrays.asList(2, 6, 7, 2);

        List<String> list = words.stream().map(String::toUpperCase).toList();
        System.out.println(list);
        List<String> list1 = words.stream().filter(x -> Character.isDigit(x.charAt(0))).toList();
        System.out.println(list1);
        List<String> list2 = words.stream().filter(x -> x.matches(".*\\d.*")).toList();
        System.out.println(list2);
        List<Integer> list3 = num.stream().filter(num1::contains).toList();
        System.out.println(list3);


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
/*
        1️⃣ Group employees by department and sort by salary (desc) inside each department.
        2️⃣ Find highest salary employee per department → Map<String, Employee>
        3️⃣ Convert list of employees into → Map<Department, List<String>> (only names).
        4️⃣ Group transactions by Type and sum the total amount.
        5️⃣ Find average salary per department with averagingDouble.
        6️⃣ Count how many times each word appears → Map<String, Long>.
        7️⃣ Group people by dept and then count → Map<Integer, Long>.
        */

        Map<String, List<Employees>> collect = emp.stream().sorted(Comparator.comparing(Employees::getSalary)).collect(Collectors.groupingBy(Employees::getDept));
        System.out.println(collect);

        Map<String, Optional<Employees>> collect1 = emp.stream().collect(Collectors.groupingBy(Employees::getDept, Collectors.maxBy(Comparator.comparing(Employees::getSalary))));

        System.out.println(collect1);
        java.util.Map<String, Double> map =emp.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDept, Collectors.averagingDouble(Employees::getSalary)));
        System.out.println(map);

        Map<String, Long> collect2 = emp.stream().collect(Collectors.groupingBy(Employees::getDept, Collectors.counting()));
        System.out.println(collect2);
    }

}
