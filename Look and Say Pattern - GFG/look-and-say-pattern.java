//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        if(n==1) return "1";
        if(n==2) return "11";
        String s ="11";
        for(int i=3;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            Integer count=1;
            s+='*';
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)!=s.charAt(j-1)){
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count=1;
                }else{
                    count++;
                }
            }
            s=sb.toString();
        }
        return s;
    }
}
