package com.test;

/**
 * Merge Two Binary Trees
 * */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	return merge(t1,t2);
    }
    
    public TreeNode merge(TreeNode t1,TreeNode t2){
    	if(t1==null&&t2==null){
    		return null;
    	}
    	else{
    		if(t1!=null&&t2!=null){
    			TreeNode tn = new TreeNode(t1.val+t2.val);
    			tn.left = merge(t1.left,t2.left);
    			tn.right = merge(t1.right,t2.right);
    			return tn;
    		}
    		else if(t1!=null){
    			TreeNode tn = new TreeNode(t1.val);
    			tn.left = t1.left;
    			tn.right = t1.right;
    			return tn;
    		}
    		else{
    			TreeNode tn = new TreeNode(t2.val);
    			tn.left = t2.left;
    			tn.right = t2.right;
    			return tn;
    		}
    	}
    }
    
    public static void main(String[] args){
    }
}