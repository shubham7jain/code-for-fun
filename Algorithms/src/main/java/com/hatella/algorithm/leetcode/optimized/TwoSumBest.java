package com.hatella.algorithm.leetcode.optimized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hatella.algorithm.leetcode.mine.TwoSum;

public class TwoSumBest {
	public static void main(String args[]) {
		int nums[] = {3, 2, 4};
		int target = 6;
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}
	
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	Set<Integer> setOfDuplicates = new HashSet<Integer>();
    	for(int i = 0; i < nums.length; i++) {
    		int a = nums[i];
    		int b = target - a;
    		if(map.get(b) != null && map.get(b) != i) {
    			return new int[]{map.get(b)+1, i+1};
    		} else {
    			map.put(nums[i], i);
    		}	
    	}
    	return new int[]{};
    }
}
