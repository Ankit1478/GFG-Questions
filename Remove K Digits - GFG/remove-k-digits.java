//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String str, int k) {
        char nums[]=str.toCharArray();
        int n=str.length();
        Stack<Character>s=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && s.peek()>nums[i] && k>0){
                s.pop();
                k--;
            }
            
            if(s.isEmpty() && nums[i]=='0')continue;
             s.push(nums[i]);
        }
        // for single elemnt
        while(!s.isEmpty() && k>0){
            s.pop();
            k--;
        }
        if(s.isEmpty())return "0";
        StringBuilder sb=new StringBuilder();
        
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}




















