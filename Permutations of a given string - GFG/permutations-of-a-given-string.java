//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String s) {
        // Code here
        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();

        // Sort the character array to ensure lexicographically sorted order
        java.util.Arrays.sort(charArray);

        generatePermutations(charArray, new boolean[charArray.length], new StringBuilder(), result);
        return result;
    }
    private void generatePermutations(char[] charArray, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == charArray.length) {
            // Add the current permutation to the result list
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (used[i] || (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1])) {
                // Skip duplicates to generate unique permutations
                continue;
            }

            // Mark the character as used
            used[i] = true;

            // Add the character to the current permutation
            current.append(charArray[i]);

            // Recur for the next index
            generatePermutations(charArray, used, current, result);

            // Revert the changes (backtrack) for the next iteration
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}