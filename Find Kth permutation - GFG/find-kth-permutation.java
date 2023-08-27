//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String kthPermutation(int n,int k) {
        // code here
        k--;
        int fact[]=new int[n+1];
        fact[0]=1;
        List<Integer>nums=new ArrayList<>();
        for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*i;
            nums.add(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int j=k/fact[i];
            k%=fact[i];
            sb.append(nums.get(j));
            nums.remove(j);
        }
        return sb.toString();
    }
}
        
