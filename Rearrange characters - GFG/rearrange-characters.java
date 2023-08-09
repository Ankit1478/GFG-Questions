//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Solution
{
    static class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
	public static String rearrangeCharacters(String str) {
	int n = str.length(); // Use length() instead of length
        Map<Character, Integer> hMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hMap.put(ch, hMap.getOrDefault(ch, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : hMap.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue())); // Fix typo and remove semicolon
        }
        
        if (pq.peek().count > Math.ceil(n / 2.0)) { // Use .count to compare with peek()
            return "-1";
        }
        
        StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        
        while (pq.size() > 1) {
            Pair temp = pq.poll();
            Pair temp2 = pq.poll();
            ans.append(temp.ch); // Append characters to StringBuilder
            ans.append(temp2.ch);
            
            if (temp.count - 1 > 0) {
                pq.add(new Pair(temp.ch, temp.count - 1)); // Fix typo and adjust count
            }
            if (temp2.count - 1 > 0) {
                pq.add(new Pair(temp2.ch, temp2.count - 1)); // Fix typo and adjust count
            }
            
            n = n - 2;
        }
        
        if (n == 1) {
            ans.append(pq.poll().ch);
        }
        
        return ans.toString(); // Convert StringBuilder to String
    }
}