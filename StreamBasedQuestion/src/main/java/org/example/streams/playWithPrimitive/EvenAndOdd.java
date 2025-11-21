package org.example.streams.playWithPrimitive;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenAndOdd {
    public static void main(String[] args) {
        //filter even and odd from list of integer
        List<Integer> list= Arrays.asList(1, 2, 3, 5, 6, 9, 8, 4);
        List<Integer> evenNumber=list.stream().filter(x->x%2==0).toList();
        System.out.println("even number: "+evenNumber);
        List<Integer> oddNumber = list.stream().filter(x->x%2!=0).toList();
        System.out.println("odd number: "+ oddNumber);

        Map<Boolean, List<Integer>> partion= list.stream().collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println("even number:"+partion.get(true));
        System.out.println("odd number:"+partion.get(false));
    }
}
