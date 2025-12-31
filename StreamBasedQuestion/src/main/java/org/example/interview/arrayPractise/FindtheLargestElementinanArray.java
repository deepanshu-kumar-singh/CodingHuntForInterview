package org.example.interview.arrayPractise;

public class FindtheLargestElementinanArray {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 2};
        int i = largestElement(arr);
        System.out.println(i);
    }

    private static int largestElement(int[] arr){

        int max=0;
        for (int i=0;i< arr.length;i++){
            if (arr[i]>max){
                max=arr[i];

            }
        }
        return max;
    }
}
