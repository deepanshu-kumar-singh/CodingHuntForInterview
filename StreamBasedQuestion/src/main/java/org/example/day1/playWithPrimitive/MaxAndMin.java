package org.example.day1.playWithPrimitive;

import java.util.*;

public class MaxAndMin {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 2, 3, 5, 6, 9, 8, 4);

        list.stream().max(Comparator.comparingInt(Integer::intValue)).ifPresent(System.out::println);

        OptionalInt max = list.stream().mapToInt(Integer::intValue).max();
        System.out.println(max.getAsInt());

        Optional<Integer> min = list.stream().min(Comparator.comparingInt(Integer::intValue));
        System.out.println(min.get());

        OptionalInt min1 = list.stream().mapToInt(Integer::intValue).min();
        System.out.println(min1.getAsInt());
    }
}
