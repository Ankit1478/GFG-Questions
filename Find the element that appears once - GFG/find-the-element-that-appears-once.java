//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int A[], int N)
    {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<N;i++){
           if(map.containsKey(A[i])){
               map.put(A[i],map.get(A[i])+1);
           }else{
               map.put(A[i],1);
           }
        }
        for(Integer it:map.keySet()){
            int freq=map.get(it);
            if(freq==1){
                return it;
            }
        }
        
        return -1;
        
    }
}