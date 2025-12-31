package org.example.interview.arrayPractise;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 4, 4};
        int newLength = removeDuplicates(arr);

        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeDuplicates(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        int index = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1]) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }
}
