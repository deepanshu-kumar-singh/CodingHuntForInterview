package org.example.interview.arrayPractise;

public class FindtheSecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 2};
        int i = secondLargestElement(arr);
        System.out.println(i);
    }

    private static int secondLargestElement(int[] arr){
        int largest=0;
        int secondlargest=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>largest){
                secondlargest=largest;
                largest=arr[i];

            }
        }
        return secondlargest;
    }
}
