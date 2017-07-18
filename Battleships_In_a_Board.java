package com.test;


/**
 * 419. Battleships in a Board
 * 最近命中率很高呀 一次性过
 * */
public class Battleships_In_a_Board {
	
    public int countBattleships(char[][] board) {
    	int amount = 0;
        int row = 0;
        while(row<board.length){
        	int col = 0;
        	while(true){//column
        		while(col<board[row].length&&(board[row][col]=='.'
        				||(row>0&&board[row-1][col]=='X'))){
        			col++;
        		}
        		if(col==board[row].length){
        			row++;
        			break;
        		}
        		else{
        			amount++;
        			while(col<board[row].length&&board[row][col]=='X'&&
        					(row==0||board[row-1][col]=='.')){
        				col++;
        			}
        		}
        	}
        }////while
        
        return amount;
    }
    
    public static void main(String[] args){
    	Battleships_In_a_Board s = new Battleships_In_a_Board(); 
    	char[][] board = {
    			{'X','.','.','X'},
    			{'.','.','.','X'},
    			{'.','.','.','X'}
    	};
    	System.out.println(s.countBattleships(board));
    }
}