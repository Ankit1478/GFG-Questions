//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class pair{
        int first;
        int second;
        int third;
        pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0] &&source[1] ==destination[1]){
            return 0;
        }
        Queue<pair>q = new LinkedList<>();
        int n=grid.length;
        int m =grid[0].length;
        
        
        int dist [][]= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        
        
         dist[source[0]][source[1]] = 0; 
        q.add(new pair(0, source[0], source[1])); 

        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!q.isEmpty()){
            pair it=q.peek();
            q.remove();
            int dis=it.first;
            int row=it.second;
            int col=it.third;
            
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && dis+1 <dist[nrow][ncol]){
                    dist[nrow][ncol]=1+dis;
                    
                    
                if(nrow==destination[0] && ncol==destination[1])    return dis + 1; 
                    q.add(new pair(1+dis,nrow,ncol));
            }
            }
    
        }
        return -1;
    }
}
