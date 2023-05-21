//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
     static class pair{
        String first;
        int second;
        pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        int n=wordList.length;
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(startWord,1));
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;
            q.remove();
            
            if(word.equals(targetWord)==true) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedwordArray[]=word.toCharArray();
                    replacedwordArray[i]=ch;
                    String replace=new String(replacedwordArray);
                    
                    if(set.contains(replace)==true){
                        set.remove(replace);
                        q.add(new pair(replace,step+1));
                    }
                }
            }
        }
        return 0;
    }
}