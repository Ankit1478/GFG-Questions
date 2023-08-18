//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer>ans=new ArrayList<>();
        
        //base case for test case 8 
        if(s==0){
            ans.add(-1);
            return ans;
        }
        
        int i=0;
        int sum=0;
        int j=0;
        
        while(j<arr.length){
            
            sum+=arr[j];
            
            while(sum>s){
                sum-=arr[i];
                i++;
            }
            
            if(sum==s){
                ans.add(i+1);
                ans.add(j+1);
                break;
            }
            j++;
        }
        
        if(ans.isEmpty()) ans.add(-1);
        return ans;
    }
}
    //   A[] = {1,2,3,7,5}   ans = 2+3+4 =12 (2 to 4) beacause1 base indexing 
    