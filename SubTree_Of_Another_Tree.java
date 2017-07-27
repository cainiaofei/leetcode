package com.test;

/**
 * 572. Subtree of Another Tree
 * */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

 public class Solution {
 
	public boolean isSubtree(TreeNode s, TreeNode t) {
	    return dfs(s,t);
    }
    
	private boolean dfs(TreeNode s,TreeNode t){
		if(t==null){
			return true;
		}
		else if(s==null){
			return false;
		}
		else{
			if(isSame(s,t)){
				return true;
			}
			else{
				return dfs(s.left,t)||dfs(s.right,t);
			}
		}
	}
	
    private boolean isSame(TreeNode t1,TreeNode t2){
    	if(t1==null && t2==null){
    		return true;
    	}
    	else if(t1!=null&&t2!=null){
    		return t1.val==t2.val&&isSame(t1.left,t2.left)&&isSame(t1.right,t2.right);
    	}
    	else {
    		return false;
    	}
    }
}