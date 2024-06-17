package com.example.algorithm.delete.scroe;

import java.util.HashMap;

/**
 * Soultion
 *
 * @author mumu
 * @date 2024/5/28
 * @description TODO
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {5, 2, 1, 2, 5, 2, 1, 2, 5};

        solution.maximumUniqueSubarray(array);
    }
    public int maximumUniqueSubarray(int[] nums) {

        HashMap<Integer,Integer> hashMap = new HashMap();

        int left = 0;


        int result = 0;
        int maxValue = 0;
        int i = 0;
        int [] sumArray = new int [nums.length];

        while(i < nums.length){
            int value = hashMap.getOrDefault(nums[i] , -1);
            if(value != -1){
                left = value + 1;
            }
            // 也可以是修改值的，java中
            hashMap.put(nums[i],i);
            result = result + nums[i];
            sumArray[i] = result;
            if(left > 0){
                maxValue = Math.max(result - sumArray[left - 1] , maxValue);
            } else {
                maxValue = sumArray[i];
            }

            i++;
        }

        return maxValue;

    }
}