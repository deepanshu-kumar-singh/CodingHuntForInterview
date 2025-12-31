package org.example.interview.arrayPractise;

public class MissingNumber {
    public static void main(String[] args) {

/*
        1. Calculate expected sum of numbers from 1 to n
        expectedSum = n * (n + 1) / 2

        2. Calculate actual sum of array elements

        3. Missing number = expectedSum - actualSum
*/


        int[] arr = {1, 3, 4, 5};
        int n=5;
        int missingNumber = findMissingNumber(arr, n);
        System.out.println(missingNumber);
    }

    private static int findMissingNumber(int[] arr, int n) {
        int expectedResult = n * (n+1)/2;
        int result =0;
        for(int i=0;i<n-1;i++){
            result= result+arr[i];
        }
        return expectedResult-result;
    }

}
