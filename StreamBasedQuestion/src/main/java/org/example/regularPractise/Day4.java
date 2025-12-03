package org.example.regularPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {

        List<Integer> num= Arrays.asList(2,6,7,11,6,7,5,77,67,2);
        List<Integer> num1= Arrays.asList(2,6,7,2);
        List<String> words = List.of("apple", "bananaana", "apple", "cat", "banana", "apple");

        List<Emp> emps= Arrays.asList(
                new Emp("Rohan", 60, 60000),
                new Emp("Aman", 50, 70000),
                new Emp("Shubham", 30, 80000),
                new Emp("Durgesh", 20, 40000),
                new Emp("Rohit", 70, 50000),
                new Emp("Cam", 90, 20000)
        );

        //Find the sum of all numbers in a list.
        int sum = num.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        //Find common elements between two lists.
        List<Integer> list2 = num.stream().filter(num1::contains).toList();
        System.out.println(list2);
        //Find all duplicate elements from a list.
        List<Integer> list = num.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);

        //Find frequency of each element in a list.
       Map<Integer, Long> map= num.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
        System.out.println(map);

        //Given a list of strings, return the longest string.
        Optional<String> max = words.stream()
                .max(Comparator.comparing(String::length));
        System.out.println(max.get());

        //Sort a list of objects based on two fields (e.g., age then salary).
        List<Emp> list1 = emps.stream()
                                       .sorted(Comparator.comparing(Emp::getAge)
                                               .thenComparing(Emp::getSalary)).toList();
        System.out.println(list1);

    }
}

class Emp{
    private String name;
    private int age;
    private int salary;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Emp(String name, int age, int salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
}