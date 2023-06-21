//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String str)
    { // create HashMap to store frequency of every character
        HashMap<Character, Integer> mp = new HashMap<>();
         
        // to store length of string
        int n = str.length();
        char ans = 0;
        int cnt = 0;
         
        // Traverse the string
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            if (cnt < mp.get(c) || (cnt == mp.get(c) && c < ans)) {
                ans = c;
                cnt = mp.get(c);
            }
        }
        return ans;
    }
    
}