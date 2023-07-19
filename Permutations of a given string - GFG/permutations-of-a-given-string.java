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
        char[]ch = s.toCharArray();
        List<String> result = new ArrayList<>();
        
        // sort the char
        java.util.Arrays.sort(ch);
        generatePermutations(ch,new boolean[ch.length],new StringBuilder(),result);
        return result;
    }
    private void generatePermutations(char[] ch, boolean[] used, StringBuilder current, List<String> ds){
        if(current.length()==ch.length){
            ds.add(current.toString());
            return;
        }
        
        for(int i=0;i<ch.length;i++){
            if (used[i] || (i > 0 && ch[i] == ch[i - 1] && !used[i - 1])) {
                // Skip duplicates to generate unique permutations
                continue;
            }
            
            used[i]=true;
            current.append(ch[i]);
            generatePermutations(ch,used,current,ds);
            
            current.deleteCharAt(current.length()-1);
            used[i]=false;
        }
    }
}