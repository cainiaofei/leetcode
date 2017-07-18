package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 457. Circular Array Loop
 * */

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<Integer>();
        int index = 0;
        while(index<nums.length){
        	int pos = index;
        	if(visited.contains(pos)){
        		index++;
        		continue;
        	}
        	else{
        		 int pre = pos;
        		 Map<Integer,Integer> cur = new HashMap<Integer,Integer>();
        		 while(nums[pre]*nums[pos]>0){
        			 visited.add(pos);
        			 if(cur.containsKey(pos)){
        				 if(cur.size()-cur.get(pos)>1){
        					 return true;
        				 }
        				 else{
        					 break;
        				 }
        			 }
        			 else{
        				 cur.put(pos, cur.size());
        				 pre = pos;
        				 pos = (pos+nums.length+nums[pos]%nums.length)%nums.length;
        			 }
        		 }
        	}
        	index++;
        }////while
        return false;
    }
    
    public static void main(String[] args){
    	CircularArrayLoop s = new CircularArrayLoop();
    	int[] nums = {2,-1,1,-2,-2};
    	boolean result = s.circularArrayLoop(nums);
    	System.out.println(result);
    }
}