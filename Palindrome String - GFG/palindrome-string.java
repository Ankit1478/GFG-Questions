//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String s) {
        int j = s.length();
        for (int i = 0; i < j / 2; i++) {
            if (s.charAt(i) != s.charAt(j - i - 1)) {
                return 0; // If any characters don't match, it's not a palindrome
            }
        }
        return 1;
    }
};