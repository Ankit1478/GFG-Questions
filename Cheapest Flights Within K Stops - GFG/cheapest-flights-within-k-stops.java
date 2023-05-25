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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
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
     static class tuple{
        int stop;
        int node;
        int distance;
        tuple(int stop,int node,int distance){
            this.stop=stop;
            this.node=node;
            this.distance=distance;
        }
    }
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
         int m =flights.length;
        ArrayList<ArrayList<pair>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        Queue<tuple>q= new LinkedList<>();
        q.add(new tuple(0,src,0));
        int dist[]= new int[n];
        for(int i=0;i<n;i++){
                dist[i]=(int)(1e9);
        }
        dist[src]=0;
        
        while(!q.isEmpty()){
            tuple it=q.peek();
            q.remove();
            int stops = it.stop;
            int nodes=it.node;
            int cost=it.distance;

            if(stops>k) continue;

            for(pair its:adj.get(nodes)){
                int adjnode =its.first;
                int dis =its.second;

                if(cost+dis<dist[adjnode] && stops<=k){
                    dist[adjnode]=cost+dis;
                    q.add(new tuple(stops+1,adjnode,cost+dis));
                }
            }
        }
        if(dist[dst]==1e9){
            return -1;
        }
        return dist[dst];
    }
}