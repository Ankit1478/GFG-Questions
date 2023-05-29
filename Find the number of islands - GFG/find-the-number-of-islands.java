//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
     static class Disjoint {
        static int[] rank = new int[10000000];
        static int[] parent = new int[10000000];
        static int[] size = new int[10000000];
        
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public static int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
     
        public static void unionBySize(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);
            if (parentU == parentV)
                return;
            if (size[parentU] < size[parentV]) {
                parent[parentU] = parentV;
                size[parentU] += size[parentV];
            } else {
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            }

        }
     }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Disjoint ds = new Disjoint(n * m);
        int[][] vis = new int[n][m];

        int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dc = {0, 1, 0, -1, -1, 1, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    vis[i][j] = 1;

                    for (int k = 0; k < 8; k++) {
                        int adjr = i + dr[k];
                        int adjc = j + dc[k];

                        if (adjr >= 0 && adjr < n && adjc >= 0 && adjc < m && grid[adjr][adjc] == '1') {
                            int nodeno = i * m + j;
                            int adjnodeno = adjr * m + adjc;

                            if (ds.findParent(nodeno) != ds.findParent(adjnodeno)) {
                                count--;
                                ds.unionBySize(nodeno, adjnodeno);
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}






















