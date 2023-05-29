//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    public static int matSearch(int matrix[][], int N, int M, int X)
    {
         int row=matrix.length-1;
        int col=0;
        while(col<matrix[0].length &&row>=0){
            if(X==matrix[row][col]){
                return 1;
            }
            if(X>matrix[row][col]){
                col++;
            }else{
                row--;
            }
        }
        return 0;
    }
}