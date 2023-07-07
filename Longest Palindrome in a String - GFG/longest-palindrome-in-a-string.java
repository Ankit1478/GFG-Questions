//{ Driver Code Starts
//Initial Template for Java

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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
      int start = 0;
        int end = 0;
        int low, high;
        int n = S.length();
        
        for (int i = 0; i < n; i++) {
            // Even length
            low = i;
            high = i + 1;
            
            while (low >= 0 && high < n && S.charAt(low) == S.charAt(high)) {
                if ((end - start) < (high - low)) {
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
            // Odd length
            low = i;
            high = i + 2;
            while (low >= 0 && high < n && S.charAt(low) == S.charAt(high)) {
                if ((end - start) < (high - low)) {
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }
        return S.substring(start, end + 1);
    }
}