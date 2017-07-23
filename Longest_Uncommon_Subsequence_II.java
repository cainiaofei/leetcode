package com.test;

/*
 * 2017/7/23 
 * 522. Longest Uncommon Subsequence II
 * 通过分析可以得到，如果存在Uncommon Subsequence 必是整个字符串，因为如果子序列在其它几个字符串里找不到的话
 * 整个更找不到 
 */
public class Solution {
	
    public int findLUSlength(String[] strs) {
        int res = -1;
        int j;
    	for(int i = 0; i < strs.length;i++){
        	for(j = 0; j < strs.length;j++){
        		if(i==j){
        			continue;
        		}
        		else if(unCommonSub(strs[i].toCharArray(),strs[j].toCharArray())){
        			;
        		}
        		else{
        			break;
        		}
        	}
        	if(j==strs.length){
        		res = Math.max(res, strs[i].length());
        	}
        }
    	return res;
    }
    
    
    /**
     * 这里判断 sub是否为chs的子序列，现在chs找到对应的第一个 然后在第二第三第四 
     */
    public boolean unCommonSub(char[] sub,char[] chs){
    	int i = 0;
    	for(char ch:chs){
    		if(sub[i]==ch){
    			i++;
    		}
    		if(i==sub.length){
				break;
			}
    	}
    	return !(i==sub.length);
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	String[] strs = {"aaa","aaa","aa"};
    	System.out.println(s.findLUSlength(strs));
    }
}