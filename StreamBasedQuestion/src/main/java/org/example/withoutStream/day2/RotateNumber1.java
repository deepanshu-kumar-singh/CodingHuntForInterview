package org.example.withoutStream.day2;

import java.util.Arrays;

public class RotateNumber1 {
    public static void main(String[] args) {
//        Original : 1 2 3 4 5
//        First k  : 1 2
//        Remaining: 3 4 5
//
//        Result   : 3 4 5 1 2

        int[] arr = {1,2,3,4,5};
        int length = arr.length;
        int[] rotate = new int[length];
        int[] rotate1 = new int[length];
        int k=2;
        int l=3;
        int index=0;
        int index1=0;

        for (int i=k;i<length;i++){
            rotate[index++]=arr[i];
        }
        for (int i=0;i<k;i++){
            rotate[index++]=arr[i];
        }

        System.out.println(Arrays.toString(rotate));

        //k=3
        for (int i=l;i<length;i++){
            rotate1[index1++]=arr[i];
        }
        for (int i=0;i<l;i++){
            rotate1[index1++]=arr[i];
        }
        System.out.println(Arrays.toString(rotate1));
    }
}
