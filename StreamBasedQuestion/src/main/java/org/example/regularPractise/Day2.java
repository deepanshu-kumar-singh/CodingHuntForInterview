package org.example.regularPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {
    public static void main(String[] args) {
        //1️⃣ Find the second highest number from a list
        List<Integer> num= Arrays.asList(2,6,7,11,5,77,67,2);
        Integer i = num.stream().distinct().sorted((x, y) -> y - x).skip(1).findFirst().get();
        System.out.println(i);

        //Find duplicate elements from a list
        List<Integer> list = num.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);

        //3️⃣ Count frequency of each character in a string
        String string =  "sweeden";
        Map<String, Long> collect = Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect);

        //Convert List<Employee> → Map<Department, List<Employee>>
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

        Map<String, List<Employees>> collect1 = emp.stream().collect(Collectors.groupingBy(Employees::getDept));
        System.out.println(collect1);
        //5️⃣ Sort employees by salary + name

        List<Employees> list1 = emp.stream()
                .sorted(Comparator.comparing(Employees::getSalary))
                .sorted(Comparator.comparing(Employees::getName))
                .toList();
        System.out.println(list1);

        //Sort employees inside each department by salary (descending)
        Map<String, List<Employees>> collect3 = emp.stream()
                .collect(
                        Collectors.groupingBy(
                                Employees::getDept, Collectors.collectingAndThen(Collectors.toList(),
                                        x -> x.stream().sorted(Comparator.comparingDouble(Employees::getSalary))
                                                .toList())));
        System.out.println(collect3);

        //Flatten nested lists then sort unique values

        List<Integer> num1= Arrays.asList(2,6,7,11,5,77,67,2);
        List<Integer> num2= Arrays.asList(22,26,27,21,25,27,27,2);
        List<Integer> num3= Arrays.asList(2,36,37,31,35,37,37,2);

        int sum = num1.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> list3 = num1.stream().filter(num2::contains).toList();
        System.out.println(list3);

        List<Integer> list2 = Stream.of(num1, num2, num3).flatMap(Collection::stream).distinct().toList();
        System.out.println(list2);

        //7️⃣ Find the longest string in a list
        List<String> words = List.of("apple", "banana", "apple", "cat", "banana", "apple");
        String s = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(s);

        //9️⃣ Convert List<Integer> into comma-separated String
        String collect2 = words.stream().collect(Collectors.joining(","));
        System.out.println(collect2);
    }
}
class Employees {
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

    public Employees(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;

    }
}