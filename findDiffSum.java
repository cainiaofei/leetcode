package com.test;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public int findTilt(TreeNode root) {
    	getSubTreeSum(root);
    	return getDiffSum(root);
    }
    
    private int getDiffSum(TreeNode tn){
    	if(tn==null){
    		return 0;
    	}
    	else{
    		int leftDiffSum = getDiffSum(tn.left);
    		int rightDiffSum = getDiffSum(tn.right);
    		int leftSum = (tn.left==null?0:tn.left.val);
    		int rightSum = (tn.right==null?0:tn.right.val);
    		int rootDiff = Math.abs(leftSum-rightSum);
    		return rootDiff + leftDiffSum + rightDiffSum;
    	}
    }    
    
    private int getSubTreeSum(TreeNode tn){
    	if(tn==null){
    		return 0;
    	}
    	else {
    		tn.val += getSubTreeSum(tn.left) + getSubTreeSum(tn.right);
    		return tn.val;
    	}
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeNode tn = new TreeNode(1);
    	tn.left = new TreeNode(2);
    	tn.right = new TreeNode(3);
    	System.out.println(s.findTilt(tn));
    }
}