package com.test;
/*
 * Maximum Average Subarray II
 * 前缀和思想很漂亮  可以用来求连续子数组的最大和 
 */
public class Solution {
	//binarySearch
    public double findMaxAverage(int[] nums, int k) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	else{
    		double[] arr = new double[nums.length];
            for(int i = 0; i < nums.length;i++){
            	arr[i] = nums[i];
            }
            double minValue = arr[0];
            double maxValue = arr[0];
            for(double ele:arr){
            	minValue = Math.min(minValue, ele);
            	maxValue = Math.max(maxValue, ele);
            }
            return binarySearch(arr,minValue,maxValue,k);
    	}
    }
    
    public double binarySearch(double[] arr,double left,double right,int k){
    	if(Math.abs(left-right)<=0.00001){
    		return left;
    	}
    	else{
    		double mid = (left + right) * 0.5;
    		boolean flag = check(arr,mid,k);
    		if(flag){
    			return binarySearch(arr,mid,right,k);
    		}
    		else{
    			return binarySearch(arr,left,mid,k);
    		}
    	}
    }
    
    public boolean check(double[] arr,double pivot,int k){
    	double[] nums = new double[arr.length];
    	for(int i = 0; i < arr.length;i++){
    		nums[i] = arr[i] - pivot;
    	}
    	
    	double[] prefixSum = getPrefixSum(nums);
    	
    	double firstKSum = 0;
    	for(int i = 0; i < k;i++){
    		firstKSum += nums[i];
    	}
    	double maxSum = firstKSum;
    	
    	double curSum = firstKSum;
    	for(int i = k;i<arr.length;i++){
    		curSum += nums[i];
    		maxSum = Math.max(maxSum, curSum-prefixSum[i-k]);
    	}
    	
    	return maxSum>=0;
    }
    
    public double[] getPrefixSum(double[] nums){
    	double[] res = new double[nums.length];
    	double minSum = 0;
    	double curSum = 0;
    	for(int i = 0; i < nums.length;i++){
    		curSum = curSum + nums[i];
    		minSum = Math.min(minSum, curSum);
    		res[i] = minSum;
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {8,9,3,1,8,3,0,6,9,2};
    	int k = 8;
    	System.out.println(s.findMaxAverage(nums, k));
    }
}