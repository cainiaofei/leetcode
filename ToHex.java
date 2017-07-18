package com.test;

public class ToHex {
    public String toHex(int num) {
    	if(num==0){
    		return "0";
    	}
    	else{
    		char[] chs = new char[8];
            int pivot = 15;
            int base = pivot;
            int index = 0;
            while(index<8){
            	int temp = base & num;
            	int result = (temp>>(index*4))&pivot;
            	if(result<10){
            		chs[index] = (char)('0'+result);
            	}
            	else{
            		chs[index] = (char)(result-10+'a');
            	}
            	index++;
            	base = (base<<4);
            }
            StringBuilder sb = new StringBuilder();
            
            //filter '0'
            int i = chs.length-1;
            while(chs[i]=='0'){
            	i--;
            }
            while(i>=0){
            	sb.append(chs[i]);
            	i--;
            }
            return sb.toString();
    	}
    }
    
    public static void main(String[] args){
    	ToHex s = new ToHex();
    	int num = 0;
    	System.out.println(s.toHex(num));
    }
}