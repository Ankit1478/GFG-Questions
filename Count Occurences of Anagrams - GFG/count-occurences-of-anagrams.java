//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character,Integer>map = new HashMap<>();
        int i=0;
        int j=0;
        int k=pat.length();
        int ans=0;
        
        
        for(int z=0;z<pat.length();z++){
            map.put(pat.charAt(z),map.getOrDefault(pat.charAt(z),0)+1);
        }
        
        int cnt = map.size(); // a=2+b=1 ==3
        while(j<txt.length()){
            if(map.containsKey(txt.charAt(j))){
                char ch=txt.charAt(j);
                int count=map.get(ch);
                count=count-1;
                map.put(ch,count);
                if(count==0){
                    cnt--;
                }
            }
            if(j-i+1<k)j++;
            else if(j-i+1==k){
                if(cnt==0){
                    ans++;
                }
                if(map.containsKey(txt.charAt(i))){
                     char ch=txt.charAt(i);
                     int count=map.get(ch);
                      count=count+1;
                       map.put(ch,count);
                      if(count==1){
                       cnt++;
                   }
                }
                i++;
                j++;
            }
            
        }
        return ans;
    }
}