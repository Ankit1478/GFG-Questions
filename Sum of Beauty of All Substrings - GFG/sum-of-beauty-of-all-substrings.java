//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int beautySum(String s) {
       int sum = 0;
        int n = s.length();
        
        // Iterate through all possible starting indices
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            
            // Iterate through all possible ending indices
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                
                // Update the frequency of the character
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                
                // Find the maximum and minimum frequency in the substring
                for (int f : freq.values()) {
                    maxFreq = Math.max(maxFreq, f);
                    minFreq = Math.min(minFreq, f);
                }
                
                // Calculate the beauty of the substring and add it to the sum
                sum += maxFreq - minFreq;
            }
        }
        
        return sum;
    }
}
        
