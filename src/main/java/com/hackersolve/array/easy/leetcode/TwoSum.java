package com.hackersolve.array.easy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    //Driver Program
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(new TwoSum().twoSum(nums, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        //create a cache out of the input elements
        Map<Integer, List<Integer>> cache = populate(nums);
        return findTwoSumEqualsTarget(cache, nums, target);
    }

    //find if the two sum equals to the target
    private int[] findTwoSumEqualsTarget(Map<Integer, List<Integer>> cache, int[] nums, int target) {

        int[] matchedIndex = new int[2];
        for(int i=0;i<nums.length;i++) {
            int first = nums[i];        //first part
            int second = target - first;    //second part

            if(first == second) {
                List<Integer> indexList = cache.get(first);
                if(indexList.size() >= 2) {
                    matchedIndex[0] = indexList.get(0);
                    matchedIndex[1] = indexList.get(1);
                    return matchedIndex;
                }
            } else {
                //first -ne second
                //check for the first and second index separately
                List<Integer> secondIndexList = cache.get(second);
                if(secondIndexList != null && secondIndexList.size() >= 1) {
                    matchedIndex[0] = i;
                    matchedIndex[1] = secondIndexList.get(0);
                    return matchedIndex;
                }
            }
        }
        return null;
    }

    //populate the cache map
    private Map<Integer, List<Integer>> populate(int[] nums) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(cache.containsKey(nums[i])) {
                List<Integer> indexList = cache.get(nums[i]);
                indexList.add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                cache.put(nums[i], indexList);
            }
        }
        return cache;
    }
}
