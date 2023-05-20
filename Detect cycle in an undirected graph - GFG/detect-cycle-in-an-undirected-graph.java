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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    static class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    // Function to detect cycle in an undirected graph.
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean []vis,int parent[]){
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(s,-1));
        vis[s]=true;
        
        while(!q.isEmpty()){
            int node=q.peek().first;
            int par=q.peek().second;
            q.remove();

            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    q.add(new pair(it,node));
                    vis[it]=true;
                }
                else if(par!=it) return true;
            }
           
    }
     return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);  
        
        for(int i=0;i<V;i++)
            if(vis[i]==false && checkForCycle(adj, i,vis, parent)) 
                    return true;
    
        return false;
    }
}