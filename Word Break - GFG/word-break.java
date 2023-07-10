//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    static int f(String s, int n, ArrayList<String> wordDict, int idx, int[] dp) {
        if (idx == n) {
            return 1;
        }
        if (idx == n) return 1;
        if (dp[idx] != 0) return dp[idx];

        int count = 0;
        for (int i = idx + 1; i <= n; i++) {
            String sub = s.substring(idx, i);
            if (wordDict.contains(sub)) {
                count += f(s, n, wordDict, i, dp);
            }
        }

        dp[idx] = count;
        return count;
    }
    public static int wordBreak(String s, ArrayList<String> wordDict )
    {
       int n = s.length();
        int[] dp = new int[n];
        return f(s, n, wordDict, 0, dp);
    }
}