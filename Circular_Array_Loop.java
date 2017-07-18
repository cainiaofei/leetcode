package com.test;

import java.util.HashSet;
import java.util.Set;

/*
 * 2017/7/18 Circular_Array_Loop
 * 忽略的地方在于 个数是指出现同样的数字之间 不是总的 
 */

public class Circular_Array_Loop {
    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        int pos = 0;
        int direction = 0;//0:init 1:forward -1:backward
        while(visited.size()!=nums.length){
        	if(cur.contains(pos)){
        		if(cur.size()>1){
        			return true;
        		}
        		else{
        			return false;
        		}
        	}
        	else if(visited.contains(pos)){
        		return false;
        	}
        	else{
        		visited.add(pos);
        		if(direction==0){
        			cur.add(pos);
        			direction = nums[pos] > 0? 1:-1;
        			pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        		else if(direction==1){
        			if(nums[pos]<0){
        				cur.clear();
        				direction = -1;
        			}
        			cur.add(pos);
    				pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        		else{
        			if(nums[pos]>0){
        				cur.clear();
        				direction = 1;
        			}
        			cur.add(pos);
        			pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        	}
        }
        return false;
    }
    
    public static void main(String[] args){
    	Circular_Array_Loop s = new Circular_Array_Loop();
    	int[] nums = {-1, 2};
    	boolean result = s.circularArrayLoop(nums);
    	System.out.println(result);
    }
}