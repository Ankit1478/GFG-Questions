//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int nums[], int N, int k){
         return helper(nums,k)-helper(nums,k-1);
    }
    static int helper(int nums[],int k){
        if(k<0) return 0;
        int i=0;
        int j=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        while(j<n){
            sum+=nums[j];
            
            while(sum>k){
                sum=sum-nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}