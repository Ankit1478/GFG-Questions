//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfSubsets(int[] arr, int n, int k) {
        // code here
        int dp[][]=new int[n+1][k+1];
        for(int row[]:dp)Arrays.fill(row,-1);
        return f(arr,0,n,k,dp)-1;
    }
    static int f(int arr[],int idx,int n,int k,int dp[][]){
        if(idx>=n){
            if(k>0){
                return 1;
            }
            return 0;
        }
        if(dp[idx][k]!=-1)return dp[idx][k];
        
        int take=0;
        if(arr[idx]<=k){
            take=f(arr,idx+1,n,k/arr[idx],dp);
         }
         int nottake=f(arr,idx+1,n,k,dp);
         
         return dp[idx][k]=take+nottake;
    }
};