package leetc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        makeIndex(root,0);
        return findLongestWidthByBfs(root);
    }

	private int findLongestWidthByBfs(TreeNode root) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<TreeNode>  queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			map.put(queue.get(0).val, queue.get(queue.size()-1).val);
			List<TreeNode> nextLevel = new LinkedList<TreeNode>();
			for(TreeNode tn:queue){
				if(tn.left!=null){
					nextLevel.add(tn.left);
				}
				if(tn.right!=null){
					nextLevel.add(tn.right);
				}
			}//for
			queue = nextLevel;
		}
		return getMaxDiff(map);
	}
	
	public int getMaxDiff(Map<Integer,Integer> map){
		int maxDiff = 0;
		for(int key:map.keySet()){
			maxDiff = Math.max(maxDiff, map.get(key)-key+1);
		}
		return maxDiff;
	}

	private void makeIndex(TreeNode root, int index) {
		if(root==null){
			return ;
		}
		else{
			root.val = index;
			makeIndex(root.left, 2*index+1);
			makeIndex(root.right, 2*index+2);
		}
	}
	
	public static void main(String[] args){
		
	}
}