package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingOfElement {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1, 3, 3, 5, 6, 9, 6, 4);

        Map<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }
}
