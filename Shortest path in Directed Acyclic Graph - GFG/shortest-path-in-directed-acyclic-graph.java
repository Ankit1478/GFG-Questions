//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static void topo(int node,ArrayList<ArrayList<pair>>adj,Stack<Integer>s,int vis[]){
        vis[node]=1;
        for(int it=0;it<adj.get(node).size();it++){
            int v=adj.get(node).get(it).first;
            if(vis[v]==0){
                topo(v,adj,s,vis);
            }
        }
        s.push(node);
    }

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<pair>>adj=new ArrayList<>();
		for (int i = 0; i < n; i++) {
              ArrayList < pair > temp = new ArrayList < pair > ();
              adj.add(temp);
       }  
		
		for(int i=0;i<m;i++){
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(u).add(new pair(v,wt));
		}
		int vis[]=new int[n];
		Stack<Integer>s=new Stack<>();
		for(int i=0;i<n;i++){
		    if(vis[i]==0){
		        topo(i,adj,s,vis);
		    }
		}
		int dist[]= new int[n];
		for(int i=0;i<n;i++){
		    dist[i]=(int)1e9;
		}
		dist[0]=0;
		while(!s.isEmpty()){
		    int node=s.peek();
		    
		    s.pop();
		    for(int i=0;i<adj.get(node).size();i++){
		        int v=adj.get(node).get(i).first;
		        int wt=adj.get(node).get(i).second;
		        
		        if(dist[node]+wt<dist[v]){
		            dist[v]=dist[node]+wt;
		        }
		    }
		}
		for(int i=0;i<n;i++){
		   if(dist[i]==1e9) dist[i]=-1;
		}
		return dist;
	}
}


























