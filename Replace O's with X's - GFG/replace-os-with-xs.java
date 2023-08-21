//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    
    static void dfs(int row,int col, boolean vis[][],char[][]mat,int delrow[],int delcol[]){
        int n =mat.length;
        int m =mat[0].length;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && mat[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,mat,delrow,delcol);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        int delrow[]={-1,0,0,1};
        int delcol[]={0,-1,1,0};
        boolean vis[][]= new boolean[n][m];
        
        // first row and last row
        for(int i=0;i<m;i++){
            if(!vis[0][i] && a[0][i]=='O'){
                dfs(0,i,vis,a,delrow,delcol);
            }
            if(!vis[n-1][i]&&a[n-1][i]=='O' ){
                dfs(n-1,i,vis,a,delrow,delcol);
            }
        }
        
        // last row and last col
        for(int j=0;j<n;j++){
             if(!vis[j][0] && a[j][0]=='O'){
                dfs(j,0,vis,a,delrow,delcol);
            }
            if(!vis[j][m-1]&&a[j][m-1]=='O' ){
                dfs(j,m-1,vis,a,delrow,delcol);
            }
        }
        // for all matrix element
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}