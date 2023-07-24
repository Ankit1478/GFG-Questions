//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][]=new int[N][W+1];
         for(int row[]: dp)
         Arrays.fill(row,-1);
          return f(N-1,W,val,wt,dp);
    }
    static int f(int idx,int W, int val[], int wt[],int dp[][]){
        if(idx==0){
            return ((int)(W/wt[0])) * val[0];
        }
        if(dp[idx][W]!=-1)return dp[idx][W];
        int taken=Integer.MIN_VALUE;
        int nottaken=f(idx-1,W,val,wt,dp);
        if(wt[idx]<=W){
            taken=val[idx]+f(idx,W-wt[idx],val,wt,dp);
        }
        return dp[idx][W]=Math.max(taken,nottaken);
    }
}