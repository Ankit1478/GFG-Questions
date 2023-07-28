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
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        int i=0;
        int j=0;
        int n=s.length();
        int ans=0;
        HashMap<Character,Integer>map = new HashMap<>();
        
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
             if(map.size()==j-i+1){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char ch1=s.charAt(i);
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0){
                        map.remove(ch1);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}