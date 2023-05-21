//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int n =s1.length();
        int m =s2.length();
        
        int dp[][]= new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=0;
        }
         for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int idx1=1;idx1<=n;idx1++){
            for(int idx2 =1;idx2<=m;idx2++){
                if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
                    dp[idx1][idx2]=1+dp[idx1-1][idx2-1];
                }
                else{
                    dp[idx1][idx2]=Math.max(dp[idx1-1][idx2],dp[idx1][idx2-1]);
                }
            }
        }
        return dp[n][m];
        
    }
    // static int f(int x,int y,String s1,String s2,int dp[][]){
    //     if(x<0 || y<0) return 0;
        
    //     if(dp[x][y]!=-1) return dp[x][y];
    //     if(s1.charAt(x)==s2.charAt(y)){
    //       return dp[x][y] = 1+f(x-1,y-1,s1,s2,dp);
    //     }
    //     return dp[x][y]=Math.max(f(x-1,y,s1,s2,dp),f(x,y-1,s1,s2,dp));
    // }
}