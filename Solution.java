package leetcodeProblems;

import java.io.Console;

class Solution {
    public boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        return true;
    }
    public String longestPalindrome(String s) {
    	int max=-1,counter=0;
    	String maxString="";
        for(int i=0;i<s.length();i++) {

            System.out.println(counter++);
            if(max>=(s.length()-i))
                     break;
        	 for(int j=s.length();j>i;j--) {
                 if(max>=(j-i))
                     break;
                 if(isPalindrome(s.substring(i,j))&&(j-i)>max) {
            	      max=j-i;
            	      maxString=s.substring(i,j);
            	      
            }
        }
    }
        return maxString;
}
}