package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepetating {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 3, 3, 5, 6, 9, 6, 4);

        List<Integer> list1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() < 2)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list1);
    }
}
