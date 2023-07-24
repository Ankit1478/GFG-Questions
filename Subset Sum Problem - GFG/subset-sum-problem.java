//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][]=new int[N][sum+1];
         for(int row[]: dp)
         Arrays.fill(row,-1);
         return f(N-1,N,arr,sum,dp);
    }
    static boolean f(int idx,int n,int arr[],int target,int[][]dp){
        if(target==0) return true;
        if(idx==0) return arr[0]==target;
        
        if(dp[idx][target]!=-1)return dp[idx][target]==0?false:true;
        
        boolean notaken=f(idx-1,n,arr,target,dp);
        boolean taken=false;
        if(arr[idx]<=target){
            taken=f(idx-1,n,arr,target-arr[idx],dp);
            dp[idx][target]=notaken||taken?1:0;
        }
         return notaken||taken;
    }
     
}