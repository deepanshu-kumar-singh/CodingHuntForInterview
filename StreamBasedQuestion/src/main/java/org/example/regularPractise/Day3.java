package org.example.regularPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {
    public static void main(String[] args) {
        //1️⃣ Find even numbers from a list
        List<Integer> num= Arrays.asList(2,6,7,11,5,77,67,2);
        String string =  "sweeden";
        List<String> words = List.of("apple", "banana", "apple", "cat", "banana", "apple");
        List<Integer> list = num.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(list);

        //2️⃣ Find unique elements from a list
        List<Integer> list1 = num.stream().distinct().toList();
        System.out.println(list1);

        //3️⃣ Find the maximum element
        Optional<Integer> max = num.stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println(max.get());

        //4️⃣ Find the minimum element
        Optional<Integer> min = num.stream().min(Comparator.comparingInt(Integer::intValue));
        System.out.println(min.get());

        //5️⃣ Sort a list in ascending order
        List<Integer> list2 = num.stream().sorted().toList();
        System.out.println(list2);

        //6️⃣ Sort a list in descending order
        List<Integer> list3 = num.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list3);

        //7️⃣ Count elements greater than 10
        long count = num.stream().filter(x -> x > 10).count();
        System.out.println(count);

        //8️⃣ Convert list of strings to uppercase
        String collect = Arrays.stream(string.split("")).map(String::toUpperCase).collect(Collectors.joining());
        System.out.println(collect);

        //9️⃣ Find the first element starting with “A”
        List<String> list4 = words.stream().map(String::toUpperCase).filter(x -> x.startsWith("A")).toList();
        System.out.println(list4);

        //1️⃣1️⃣ Sum of all elements
        int sum = num.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //1️⃣2️⃣ Convert list to a comma-separated string
        String collect1 = words.stream().collect(Collectors.joining(","));
        System.out.println(collect1);

        //1️⃣3️⃣ Find duplicate elements
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list5 = num.stream().filter(x -> !set.add(x)).toList();
        System.out.println(list5);

        //1️⃣4️⃣ Group words by length
        Map<Integer, List<String>> collect2 = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect2);

        //1️⃣6️⃣ Find the second-highest number
        Optional<Integer> first = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(first.get());

        //2️⃣0️⃣ Find frequency of each element
        Map<String, Long> collect3 = Arrays.stream(string.split(""))
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

        //merging lists

        List<Integer> num1= Arrays.asList(2,6,7,11,5,77,67,2);
        List<Integer> num2= Arrays.asList(22,26,27,21,25,27,27,2);
        List<Integer> num3= Arrays.asList(2,36,37,31,35,37,37,2);

        List<Integer> list6 = Stream.of(num1, num2, num3).flatMap(Collection::stream).filter(x -> x % 2 == 0).toList();
        System.out.println(list6);
        List<Integer> list7 = num1.stream().filter(num2::contains).toList();
        System.out.println(list7);

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

        //Group employees by department
        Map<String, List<Employees>> collect4 = emp.stream().collect(Collectors.groupingBy(Employees::getDept));
        System.out.println(collect4);

        //Sort employees inside each department by salary (descending)
        Map<String, List<Employees>> collect5 = emp.stream().collect(Collectors.groupingBy(
                Employees::getDept, Collectors.collectingAndThen(
                        Collectors.toList(), x -> x.stream().sorted(Comparator.comparing(Employees::getSalary)).toList())));
        System.out.println(collect5);

        //highest salary employee per department
        Map<String, Optional<Employees>> collect6 = emp.stream().
                collect(Collectors.groupingBy(
                        Employees::getDept, Collectors.maxBy(
                                Comparator.comparingDouble(Employees::getSalary))));
        System.out.println(collect6);

        //Find average salary per department with averagingDouble
        Map<String, Double> collect7 = emp.stream()
                .collect(Collectors.groupingBy(
                        Employees::getDept, Collectors.averagingDouble(
                                Employees::getSalary)));
        System.out.println(collect7);

        //Find employee with longest name per department
        Map<String, Optional<Employees>> collect8 = emp.stream().collect(
                Collectors.groupingBy(
                        Employees::getDept, Collectors.maxBy(Comparator.comparing(Employees::getName))));
        System.out.println(collect8);


    }
}