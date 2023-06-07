//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        int bit = getithbit(num, i);
        int setBit = setithbit(num, i);
        int clearBit = Clearithbit(num, i);
        
        System.out.print(bit + " " + setBit + " " + clearBit);
        
    }
    public static int getithbit(int n,int i){
        int bit=1<<i-1;
        if((n&bit)==0){
            return 0;
        }
        return 1;
    }
    static int setithbit(int n,int i){
        int bit=1<<i-1;
        return (n|bit);
    }
    static int Clearithbit(int n,int i){
        int bitmask=~(1<<i-1);
        return n&bitmask;
    }
}
