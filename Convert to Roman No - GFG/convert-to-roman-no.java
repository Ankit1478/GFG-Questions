//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			Solution ob = new Solution();
			System.out.println(ob.convertToRoman(N));
			t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    static String pattern(int num){
        if(num == 1) return "I";
        else if(num == 4) return "IV";
        else if(num == 5) return "V";
        else if(num == 9) return "IX";
        else if(num == 10) return "X";
        else if(num == 40) return "XL";
        else if(num == 50) return "L";
        else if(num == 90) return "XC";
        else if(num == 100) return "C";
        else if(num == 400) return "CD";
        else if(num == 500) return "D";
        else if(num == 900) return "CM";
        else if(num == 1000) return "M";
        return "";
    }
	String convertToRoman(int n) {
		//code here
		StringBuilder sb = new StringBuilder();
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		
		for(int i=0;i<values.length;i++){
		    while(n>=values[i]){
		        sb.append(pattern(values[i]));
		        n-=values[i];
		    }
		}
          return sb.toString();
	}
}











