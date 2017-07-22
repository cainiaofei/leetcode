package com.test;

import java.util.HashSet;
import java.util.Set;

//521. Longest Uncommon Subsequence I
public class Solution {
	
    public int findLUSlength(String a, String b) {
    	if(a.length()!=b.length()){
    		return a.length()>b.length()?a.length():b.length();
    	}
    	else{
    		Set<Character> setA = new HashSet<Character>();
    		Set<Character> setB = new HashSet<Character>();
    		
    		for(char ch:a.toCharArray()){
    			setA.add(ch);
    		}
    		
    		for(char ch:b.toCharArray()){
    			if(!setA.contains(ch)){
    				return a.length();
    			}
    			else{
    				setB.add(ch);
    			}
    		}
    		
    		if(setA.size()==setB.size()){
    			return -1;
    		}
    		else{
    			return a.length();
    		}
    	}
    }
}