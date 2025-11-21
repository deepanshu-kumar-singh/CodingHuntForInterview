package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 3, 3, 5, 6, 9, 6, 4);
        List<Integer> distinct = list.stream().distinct().toList();
        System.out.println(distinct);

        Set<Integer> collect = list.stream().collect(Collectors.toSet());
        System.out.println(collect);

    }
}
