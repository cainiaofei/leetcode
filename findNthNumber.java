package leetc;

class Node{
	int number;
	int left, right;
	public Node(int number, int left, int right){
		this.left = left;
		this.right = right;
		this.number = number;
	}
}

public class Solution {
    public int findNthDigit(int n) {
    	if(n<10){
    		return n;
    	}
    	int maxNumber = getMaxNumber();
    	Node[] nodes = new Node[maxNumber+1];
    	init(nodes);
    	int interval = findInWhichInterval(nodes, n);
    	if(interval==-1){
    		return -1;
    	}
    	else{
    		int remain = n - nodes[interval-1].right;
    		return getDigit(interval, remain-1);//from zero 
    	}
    }
    
    private int getDigit(int numPerData, int n) {
    	int number = (n / numPerData);
    	int curNum = (int)Math.pow(10, numPerData-1) + number;
    	int pos = n - (numPerData * number);
    	return curNum / (int)Math.pow(10, numPerData-pos-1) % 10;
	}

	private int findInWhichInterval(Node[] nodes, int n) {
		for(int i = 1; i < nodes.length;i++){
			if(n<=nodes[i].right){
				return i;
			}
		}
		return -1;
	}

	private void init(Node[] nodes) {
    	nodes[0] = new Node(0,0,0);
    	for(int i = 1; i < nodes.length;i++){
    		int numberInterval;
    		if(i==nodes.length-1){
    			numberInterval = Integer.MAX_VALUE - (int)Math.pow(10, i-1) + 1;
    		}
    		else{
    			numberInterval = getNumberInThisInterval(i)-(int)Math.pow(10, i-1) + 1;
    		}
    		int left = nodes[i-1].right + 1;
			int right = nodes[i-1].right + numberInterval * i;
			if(right<0){
				right = Integer.MAX_VALUE;
			}
			nodes[i] = new Node(i, left, right);
    	}
	}

	private int getNumberInThisInterval(int count) {
		int res = 0;
		while(count>0 ){
			res = res * 10 + 9;
			count--;
		}
		return res;
	}

	public int getMaxNumber(){
    	return (Integer.MAX_VALUE+"").length();
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int n = 1000000000;
    	System.out.println(s.findNthDigit(n));
    }
}