package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;

public class DigitStartWith {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("1apple", "banana", "apple", "3cat", "banana", "apple");
        List<String> list = words.stream().filter(x -> Character.isDigit(x.charAt(0))).toList();
        System.out.println(list);

        List<String> list1 = words.stream().filter(x -> x.startsWith("1")).toList();
        System.out.println(list1);

        List<String> list2 = words.stream().filter(x -> x.matches(".*\\d.*")).toList();
        System.out.println(list2);
    }
}
