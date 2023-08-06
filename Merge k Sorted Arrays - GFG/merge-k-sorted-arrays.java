//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class pair implements Comparable<pair>{
        int value;
        int index;
        int nextidx;
        pair(int value,int index,int nextidx){
            this.value=value;
            this.index=index;
            this.nextidx=nextidx;
        }
        public int compareTo(pair p2){
            return this.value-p2.value;
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        ArrayList<Integer>ans=new ArrayList<>();
        
        PriorityQueue<pair>pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            pq.add(new pair(arr[i][0],i,1));
        }
        
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            ans.add(curr.value);
       
        
        if(curr.nextidx<k){
            pq.add(new pair(arr[curr.index][curr.nextidx], curr.index, curr.nextidx + 1));

        }
        }
        return ans;
    }
}


































