//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends




// User function Template for Java

class Solution {
    public long count(int coins[], int n, int sum) {
       long dp[][] = new long[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int idx = 1; idx <= n; idx++) {
            for (int s = 1; s <= sum; s++) {
                long notpick = dp[idx - 1][s];
                long pick = (s >= coins[idx - 1]) ? dp[idx][s - coins[idx - 1]] : 0;
                dp[idx][s] = pick + notpick;
            }
        }
        return dp[n][sum];
    }
//     static long f(int idx,int coins[],int tar,long[][]dp){
//       if(idx==0){
//           if(tar%coins[idx]==0){
//               return 1;
//           }
//           return 0;
//       }
//       if(tar==0) return 1;
      
//       if(dp[idx][tar]!=-1) return dp[idx][tar];
//       long notpick=f(idx-1,coins,tar,dp);
//       long pick=0;
//       if(tar>=coins[idx]){
//           pick=f(idx,coins,tar-coins[idx],dp);
//       }
//       return dp[idx][tar]=pick+notpick;
//     }
}