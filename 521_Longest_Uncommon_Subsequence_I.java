package com.test;
public class Solution {
	
	//521. Longest Uncommon Subsequence I
    public int findLUSlength(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int aFromb = dp(a,b);
        int bFroma = dp(b,a);
        return aFromb>bFroma? aFromb : bFroma;
    }
    
    public int dp(char[] a,char[] b){
    	int[][] dp = new int[a.length][b.length];
    	for(int i = 1; i<dp.length;i++){
    		for(int j = 1; j < dp[i].length;j++){
    			if(dp[i][j]>0){
    				dp[i][j] = dp[i-1][j] + 1;
    			}
    			else{
    				if(dp[i][j-1]==0){
    					dp[i][j] = 0;
    				}
    				else{
    					if(dp[i][j-1]>1){
    						dp[i][j-1] = dp[i][j-1];
    					}
    				}
    			}
    		}
    	}
    	return dp[a.length-1][b.length-1];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	
    }
}