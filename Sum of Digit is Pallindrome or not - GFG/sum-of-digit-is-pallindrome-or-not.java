//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int N) {
        int sum=0;
        while(N>0){
            int res=N%10;
            sum=sum+res;
            N=N/10;
        }
        String sumStr = String.valueOf(sum);
        int i=0;
        int j=sumStr.length()-1;
        while(i<j){
            if (sumStr.charAt(i) != sumStr.charAt(j)) {
                return 0; // Not a palindrome
            }
            i++;
            j--;
        }
        return 1;
    }
   
}