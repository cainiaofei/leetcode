package com.test;
//643. Maximum Average Subarray I
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
    	int curSum = 0;
        for(int i = 0; i < k;i++){
        	curSum += nums[i];
        }
        maxSum = curSum;
        for(int i = k; i < nums.length;i++){
        	int nextSum = curSum + nums[i] - nums[i-k];
        	maxSum = Math.max(nextSum, maxSum);
        	curSum = nextSum;
        }
        return maxSum*1.0/k;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {1,12,-5,-6,50,3};
    	int k = 4;
    	System.out.println(s.findMaxAverage(nums, k));
    }
}