//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
         public int maxsting;
        public int currstring;
        public String maxValue;
    String longestPalindrome(String s){
         for(int i=0;i<s.length();i++){
        checkneighbour(i,i,s);
        checkneighbour(i,i+1,s);
    }
    return maxValue;
    }
    
    
     public  void checkneighbour(int left,int right,String s){
        while(left>=0 && right<s.length() &&s.charAt(left)==s.charAt(right)){
            currstring=right-left+1;
              if(currstring>maxsting){
            maxsting=currstring;
            maxValue= s.substring(left, right + 1);
        }
        left--;
        right++;
        }
      
    }
}