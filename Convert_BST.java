package com.test;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public TreeNode convertBST(TreeNode root) {
    	Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
    	getSubTreeSumByDfs(root,map);
    	updateAllNode(root,map);
    	return root;
    }
    
    public void updateAllNode(TreeNode root,Map<TreeNode,Integer> map){
    	if(root==null){
    		return ;
    	}
    	else {
    		if(root.right!=null){
    			root.val += map.get(root.right);
    		}
    		updateAllNode(root.left,map);
    		updateAllNode(root.right,map);
    	}
    }
    
    public int getSubTreeSumByDfs(TreeNode tn,Map<TreeNode,Integer> map){
    	if(tn==null){
    		return 0;
    	}
    	else{
    		int leftSum = getSubTreeSumByDfs(tn.left,map);
    		int rightSum = getSubTreeSumByDfs(tn.right,map);
    		int subTreeSum = tn.val + leftSum + rightSum;
    		map.put(tn, subTreeSum);
    		return subTreeSum;
    	}
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(13);
    	s.convertBST(root);
    }
}