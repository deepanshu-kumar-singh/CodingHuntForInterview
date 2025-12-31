package org.example.interview.arrayPractise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(arr, target);
        System.out.println("brute force"+Arrays.toString(ints));
        int[] ints1 = twoSumOptimized(arr, target);
        System.out.println("optimize"+ Arrays.toString(ints1));
    }

    private static int[] twoSum(int[] arr, int target){
        for(int i=0; i< arr.length;i++){
            for (int j=i; j<arr.length;j++){
                if (arr[i] + arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    private static int[] twoSumOptimized(int[] arr, int target) {
        Map<Integer, Integer> map =  new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int i1 = target - arr[i];
            if (map.containsKey(i1)){
                return new int[]{map.get(i1),i};
            }
            map.put(arr[i],i);
        }
        return new
                int[]{};
    }

}
