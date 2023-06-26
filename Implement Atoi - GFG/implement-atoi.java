//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	    int i=0;
        int n =s.length();
        int res=0;
        int sign=1;
        boolean iscontain=false;
        if(n==0) return 0;

        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
        }

        for(;i<n;i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                res=res*10+s.charAt(i)-48;
            }
            else{
                iscontain=true;
            }
        }
        return iscontain?-1:res*sign;
    }
}
