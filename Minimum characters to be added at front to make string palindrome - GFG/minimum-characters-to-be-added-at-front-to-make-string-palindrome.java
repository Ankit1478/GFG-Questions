//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static int minChar(String str1) {
       int n = str1.length();
        int start = 0;
        int end = n - 1;
        int res = 0;
        while (start < end) {  // While the pointers have not met in the middle of the string
            if (str1.charAt(start) == str1.charAt(end)) {  // If the characters at the start and end pointers are equal
                start++;  // Move the start pointer to the right
                end--;  // Move the end pointer to the left
            }
            else {
                res++;  // Increment the count of characters to be added
                start = 0;  // Reset the start pointer to the beginning of the string
                end = n - res - 1;  // Reset the end pointer to the end of the string with a reduced number of characters
            }
        }
        return res;  
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends