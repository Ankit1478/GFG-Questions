//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}


// } Driver Code Ends




//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
    {
        if(n == 1) return (long) arr[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        
        String s1="";
        String s2="";
        
        while(!pq.isEmpty()){
            s1+=pq.poll();
            if(pq.isEmpty()) break;
            s2+=pq.poll();
        }
        long a=Long.parseLong(s1);
        long b=Long.parseLong(s2);
        return a+b;
    }
}