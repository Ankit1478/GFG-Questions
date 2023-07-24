//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int dp[][]=new int[n][n+1];
    
        for(int i=0;i<=n;i++){
            dp[0][i]=i*price[0];
        }
        for(int idx=1;idx<n;idx++){
            for(int j=0;j<=n;j++){
                
                int rodlength=idx+1;
                
                 int take=Integer.MIN_VALUE;
                 
                 int notake=dp[idx-1][j];
                 
                   if(rodlength<=j){
                       take=price[idx]+dp[idx][j-rodlength];
                   }
            dp[idx][j]=Math.max(notake,take);
            }
           
        }
         return dp[n-1][n];
    }
}
