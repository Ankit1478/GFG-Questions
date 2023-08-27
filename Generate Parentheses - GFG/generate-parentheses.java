//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ds=new ArrayList<>();
        char ch[]=new char[2*n];
        f(0,0,0,n,ch,ds);
        return ds;
    }
    static void f(int idx,int open,int close,int n,char ch[],List<String>ds){
        if(close==n){
            ds.add(new String(ch));
            return ;
        }
        else {
            if(open>close){
                ch[idx]=')';
                f(idx+1,open,close+1,n,ch,ds);
            }
            if(open<n){
                ch[idx]='(';
                f(idx+1,open+1,close,n,ch,ds);
            }
        }
    }
}