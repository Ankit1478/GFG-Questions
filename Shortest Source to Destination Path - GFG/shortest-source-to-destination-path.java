//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
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
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        if (A[0][0] == 0)
            return -1;
        boolean vis[][] = new boolean[N][M];
        vis[0][0] = true;
        q.add(new Pair(0, 0, 0));

        int ans = Integer.MAX_VALUE; // Corrected from Integer.MIN_VALUE to Integer.MAX_VALUE
        while (!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            int tm = q.peek().time;
            q.poll();

            if (x == X && y == Y) {
                ans = Math.min(ans, tm);
                continue;
            } else {
                int gridrow[] = { -1, 0, 1, 0 };
                int gridcol[] = { 0, 1, 0, -1 };

                for (int i = 0; i < 4; i++) {
                    int nrow = x + gridrow[i];
                    int ncol = y + gridcol[i];
                    if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M && A[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                        q.add(new Pair(nrow, ncol, tm + 1));
                        vis[nrow][ncol] = true;
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) // Corrected from Integer.MIN_VALUE to Integer.MAX_VALUE
            return -1;
        return ans;
    }
};












