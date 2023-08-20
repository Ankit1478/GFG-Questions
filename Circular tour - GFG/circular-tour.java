//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int gas[], int cost[])
    {
        int TotalGas=0;
        int TotalCost=0;
        int n=gas.length;

        for(int i=0;i<n;i++){
            TotalGas+=gas[i];
        }
        for(int i=0;i<n;i++){
            TotalCost+=cost[i];
        }

        if(TotalCost>TotalGas){
            return -1;
        }

        int nextidx=0;
        int Remaing_Fuel=0;
        for(int i=0;i<n;i++){
            Remaing_Fuel+=gas[i]-cost[i];
            if(Remaing_Fuel<0){
                nextidx=i+1;
                Remaing_Fuel=0;
            }
        }
        return nextidx;
    }
}