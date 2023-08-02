//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class Pair {
        int first;
        int second;
        int time;

        Pair(int first, int second, int time) {
            this.first = first;
            this.second = second;
            this.time = time;
        }
    }
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int N = grid.length;
        int area = 0;
        int M = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[N][M];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    q.add(new Pair(i, j, 1));
                    area = 1;
                    vis[i][j] = true;

                    int gridrow[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
                    int gridcol[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
                    while (!q.isEmpty()) {
                        int x = q.peek().first;
                        int y = q.peek().second;
                        int tm = q.peek().time;
                        q.poll();

                        for (int k = 0; k < 8; k++) {
                            int nrow = x + gridrow[k];
                            int ncol = y + gridcol[k];
                            if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M && grid[nrow][ncol] == 1
                                    && !vis[nrow][ncol]) {
                                q.add(new Pair(nrow, ncol, tm + 1));
                                area++;
                                vis[nrow][ncol] = true;
                            }
                        }
                    }

                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }
}