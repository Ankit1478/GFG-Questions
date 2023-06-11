//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int n)
    {
        int count=0;
        int element =0;
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                element=nums[i];
            }
            else if(nums[i]==element) count++;
            else count--;
        }
        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==element) count1++;
            if(count1>n/2) return element;
        }
        return -1;
    }
}
