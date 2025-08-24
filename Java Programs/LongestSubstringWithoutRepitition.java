import java.util.HashSet;

public class LongestSubstringWithoutRepitition {
	
	public static void main(String[] args) {
	
		String str = "abcdab";
		String substring = "";
		String longestSubstring = "";
		
		HashSet<Character> set = new HashSet<Character>();
		
		
		for(int i=0; i< str.length(); i++) {
			char c = str.charAt(i);
			
			if(set.add(c)) {
				substring = substring + c;	
			} 
			else {
				substring = "";
			}
			
			if(substring.length() > longestSubstring.length()) {
				longestSubstring = substring;
			}
			
		}
		
		System.out.println("Longest Substring WithoutRepitition : "+longestSubstring); 

	}

}
