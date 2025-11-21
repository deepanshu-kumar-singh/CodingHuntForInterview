package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxingOccuring {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 3, 3, 5, 6, 3, 6, 4);

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(x->x.getKey())
                .ifPresent(System.out::println);
    }
}
