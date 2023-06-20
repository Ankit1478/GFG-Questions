//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
      String[] words = S.split("\\.");
    int n = words.length;
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
        sb.append(words[i]);
        if (i > 0) {
            sb.append(".");
        }
    }
    return sb.toString();
    }
}