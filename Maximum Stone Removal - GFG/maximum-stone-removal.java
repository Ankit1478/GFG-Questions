//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
       static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }

    int maxRemove(int[][] stones, int n) {
        
          int maxrow=0;
        int maxcol=0;
        for(int i=0;i<n;i++){
            maxrow=Math.max(maxrow,stones[i][0]);
            maxcol=Math.max(maxcol,stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxrow+maxcol+1);
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++){
            int noderow=stones[i][0];
            int nodecol =stones[i][1]+maxrow+1;
            ds.unionBySize(noderow,nodecol);
            map.put(noderow,1);
            map.put(nodecol,1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer>it:map.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()){
                count++;
            }
        }
        return n-count;
    }
};
