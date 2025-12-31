package org.example.interview.arrayPractise;

import java.util.Arrays;

public class MoveZeroToLast {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] ints = moveZeros(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] moveZeros(int[] arr){
        int[] arr1= new int[arr.length];
        int index=0;
        for (int j : arr) {
            if (j != 0) {
                arr1[index] = j;
                index++;
            }
        }
        while (index< arr.length){
            arr1[index]=0;
            index++;
        }
        return arr1;
    }
}
