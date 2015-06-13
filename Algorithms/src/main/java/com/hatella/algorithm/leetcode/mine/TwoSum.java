package com.hatella.algorithm.leetcode.mine;

import java.util.Arrays;

public class TwoSum {
	public static void main(String args[]) {
		int nums[] = {3, 2, 4};
		int target = 6;
		TwoSum twoSum = new TwoSum();
		int[] result = twoSum.twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}
	
    public int[] twoSum(int[] nums, int target) {
    	int[] previousNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int indexes[] = new int[2];
        int length = nums.length - 1;
        int i = 0;
        while(i < length) {
            if(nums[i] + nums[length] == target) {
                break;
            } else if(nums[i] + nums[length] > target) {
                length--;
            } else {
                i++;
            }
        }
        int index1 = -1, index2 = -1;
        
        for(int j = 0; j < previousNums.length ; j++) {
        	if(previousNums[j] == nums[i] || previousNums[j] == nums[length]) {
        		index1 = index2;
        		index2 = j;
        	}
        }
        indexes[0] = index1 + 1;
        indexes[1] = index2 + 1;
 		return indexes;
    }
}
