package com.test;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * the start point maybe not the first
 */

public class Circular_Array_Loop1 {
    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        Map<Integer,Integer> cur = new HashMap<Integer,Integer>();
        
        int pos = 0; 
        int direction = 0;//0:init 1:forward -1:backward
        while(visited.size()!=nums.length){
        	if(cur.containsKey(pos)){
        		if(cur.size()-cur.get(pos)>1){
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
        			cur.put(pos, cur.size());
        			direction = nums[pos] > 0? 1:-1;
        			pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        		else if(direction==1){
        			if(nums[pos]<0){
        				cur.clear();
        				direction = -1;
        			}
        			cur.put(pos, cur.size());
    				pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        		else{
        			if(nums[pos]>0){
        				cur.clear();
        				direction = 1;
        			}
        			cur.put(pos, cur.size());
        			pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        		}
        	}
        }
        return false;
    }
    
    public static void main(String[] args){
    	Circular_Array_Loop1 s = new Circular_Array_Loop1();
    	int[] nums = {3,1, 2};
    	boolean result = s.circularArrayLoop(nums);
    	System.out.println(result);
    }
}