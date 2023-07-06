//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String s)
    {  int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(s, n, n, dp);
        
    }
    static int f(String s,int i ,int j,int dp[][]){
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
            return dp[i][j] = 1 + f(s, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(f(s, i - 1, j, dp), f(s, i, j - 1, dp));
    }
}