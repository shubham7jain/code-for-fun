package com.rehan.algorithm.leetcode.mine;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		
		int no[]={2,7,11,15};
		int target=22;
		int indices[]=new int[2];
		TwoSum ts=new TwoSum();
		indices=ts.twoSum(no, target);
	    System.out.println("index1 = "+indices[0]+", index2 = "+indices[1]);
	
	}
	
	    public int[] twoSum(int[] nums, int target) {
	    	
	    	int [] no = Arrays.copyOf(nums, nums.length);
	    	Arrays.sort(nums);
			int i=0,j=nums.length-1;
			int indices[]=new int[2];
			int index1=0,index2=0;
			while(i<j)
			{
				if(nums[i]+nums[j]==target)
					break;
				else if(nums[i]+nums[j]>target)
					j--;
				else
					i++;
			}
			
			for(int k=0;k<no.length;k++)
			{
				if((no[k]==nums[i])||(no[k]==nums[j]))
				{
					index1=index2;
					index2=k;
				}
			}
			
			indices[0]=index1+1;
			indices[1]=index2+1;
	    	return indices;
	        
	    }


}
