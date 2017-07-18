package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
* 2017/7/16 414.third Maximum Number
* 快排还是有道理的，保证left走过的都是比pivot大的 right走过的都是比pivot小的  反*之也是
*/
public class Third_Maximum_Number {
	public int thirdMax(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums){
			set.add(num);
		}
		int[] distincts = new int[set.size()];
		int index = 0;
		for(int ele:set){
			distincts[index++] = ele;
		}
		if(distincts.length<3){
			Arrays.sort(distincts);
			return distincts[distincts.length-1];
		}
		else{
			int left = 0,right = distincts.length-1;
			int target = 2;
			return findThirdMaxByQuickSort(distincts,left,right,target);
		}
    }
	
	private int findThirdMaxByQuickSort(int[] nums,int left,int right,int target) {
		int originLeft = left,originRight = right;
		int pivot = left;
		int temp = nums[left];
		while(left<=right){
			while(right>=left){
				if(nums[right]>temp){
					nums[pivot] = nums[right];
					pivot = right;
					right--;
					break;
				}
				else{
					right--;
				}
			}
			
			while(left<=right){
				if(nums[pivot]<temp){
					nums[pivot] = nums[left];
					pivot = left;
					left++;
					break;
				}
				else{
					left++;
				}
			}
		}
		
		nums[pivot] = temp;
		if(pivot==target){
			return nums[pivot];
		}
		else if(pivot>target){
			return findThirdMaxByQuickSort(nums,originLeft,pivot-1,target);
		}
		else{
			return findThirdMaxByQuickSort(nums,pivot+1,originRight,target);
		}
	}
	
	public static void main(String[] args){
		Third_Maximum_Number s = new Third_Maximum_Number();
		int[] nums = {2,2,3,1};
		System.out.println(s.thirdMax(nums));
	}
}
