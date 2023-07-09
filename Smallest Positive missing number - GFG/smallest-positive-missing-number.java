//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int A[], int size)
    {
        int n = A.length;
		// Let this 1e6 be the maximum element provided in
		// the array;
		int N = 1000010;
		// To mark the occurrence of elements
		boolean[] present = new boolean[N];
		int maxele = Integer.MIN_VALUE;

		// Mark the occurrences
		for (int i = 0; i < n; i++) {
			if (A[i] > 0 && A[i] <= n)
				present[A[i]] = true;

		
			maxele = Math.max(maxele, A[i]);
		}

		// Find the first element which didn't
		// appear in the original array
		for (int i = 1; i < N; i++)
			if (!present[i])
				return i;

		// If the original array was of the
		// type {1, 2, 3} in its sorted form
		return maxele + 1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends