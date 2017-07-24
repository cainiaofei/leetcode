package com.test;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


/**
 * 2017/7/24  
 * 538. Convert BST to Greater Tree
 * 细腻的分析问题
 */

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTraverse(root,list);
        
        int subSum = list.get(list.size()-1).val;
        
        for(int i = list.size()-2;i>=0;i--){
        	int temp = subSum + list.get(i).val;
        	list.get(i).val += subSum;
        	subSum = temp;
        }
        return root;
    }

	private void inOrderTraverse(TreeNode root, List<TreeNode> list) {
		if(root==null){
			return ;
		}
		else{
			inOrderTraverse(root.left,list);
			list.add(root);
			inOrderTraverse(root.right,list);
		}
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(15);
		s.convertBST(root);
	}
}