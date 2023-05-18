//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
   static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort012(int a[], int n)
    {
        int low=0, mid=0,high=n-1;
        while(mid<=high){
        if(a[mid]==0){
            swap(a,low,mid);
            low++;
            mid++;
        }
        else if(a[mid]==1){
            mid++;
        }
        else if(a[mid]==2){
            swap(a,mid,high);
            high--;
        }
    }
    }
    //   int i = 0, j = n - 1;
    // while (i < j) {
    //     if (a[i] != 0 && a[j] == 0) {
    //         int temp = a[i];
    //         a[i] = a[j];
    //         a[j] = temp;
    //         i++;
    //         j--;
    //     } else if (a[i] == 0) {
    //         i++;
    //     } else if (a[j] == 0) {
    //         j--;
    //     }
    // }
    
    // i = 0;
    // j = n - 1;
    // while (i < j) {
    //     if (a[i] != 2 && a[j] == 2) {
    //         int temp = a[j];
    //         a[j] = a[i];
    //         a[i] = temp;
    //         i++;
    //         j--;
    //     } else if (a[i] == 2) {
    //         i++;
    //     } else if (a[j] == 2) {
    //         j--;
    //     }
    // }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends