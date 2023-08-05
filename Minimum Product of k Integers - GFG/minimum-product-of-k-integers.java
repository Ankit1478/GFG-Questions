//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            
            Solution obj = new Solution();
            
            System.out.println(obj.minProduct(a,n,k));
        }
        
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod=(int)1e9 + 7;
    
    int minProduct(int arr[], int n,int k)
    {
        // Complete the function
        PriorityQueue<Integer>maxheap=new PriorityQueue<>(Comparator.reverseOrder());
        int ans=1;
        for(int i=0;i<n;i++){
            
            maxheap.add(arr[i]);
            
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        long result = 1;
        while (!maxheap.isEmpty()) {
            result = (result * maxheap.poll()) % mod;
        }

        return (int) result;
    }   
}

