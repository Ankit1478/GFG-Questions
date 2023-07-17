//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
		string FirstNonRepeating(string A){
		    vector<int> counter(26, false);
		    int j=0;
		    string ans ="";
		    for(int i=0; i<A.size(); i++){
		        counter[A[i]-'a']++;
		        while(j<=i && counter[A[j]-'a'] > 1)
		            j++;
		        if(i!=0 && i+1==j)
		            ans.push_back('#');
		        else
		            ans.push_back(A[j]);
		    }
		    return ans;
		}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string A;
		cin >> A;
		Solution obj;
		string ans = obj.FirstNonRepeating(A);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends