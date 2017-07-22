package com.test;

import java.util.HashSet;
import java.util.Set;

//dfs 547. Friend Circles
public class Solution {
    public int findCircleNum(int[][] matrix) {
    	int count = 0;
        Set<Integer> set = new HashSet<Integer>(); 
        for(int i = 0; i < matrix.length;i++){
        	if(set.contains(i)){
        		continue;
        	}
        	else{
        		count++;
        		set.add(i);
        		dfs(matrix,i,set);
        	}
        }
        return count;
    }
    
    public void dfs(int[][] matrix,int cur,Set<Integer> set){
    	for(int i = 0; i < matrix.length;i++){
    		if(matrix[i][cur]==1&&!set.contains(i)){
    			set.add(i);
    			dfs(matrix,i,set);
    		}
    	}
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[][] matrix = {
    			{1,1,0},
    			{1,1,0},
    			{0,0,1}
    	};
    	
    	System.out.println(s.findCircleNum(matrix));
    }
}