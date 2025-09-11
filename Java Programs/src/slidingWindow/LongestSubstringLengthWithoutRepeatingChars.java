package slidingWindow;

import java.util.HashMap;

public class LongestSubstringLengthWithoutRepeatingChars {
	
	
	public static void main(String[] args) {
		
		String s = "pwwkew"; // Output: 3 'wke'
		
		int start = 0, end = 0, maxLength = 0;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			
			if(map.containsKey(c)) {
				start = Math.max(start, map.get(c)+ 1);
				
			}
			map.put(c, end);
			
			maxLength = Math.max(maxLength, end - start + 1);		
			
		}
		

		
		System.out.println("Length of the longest substring without duplicate characters: "+ maxLength);

	}
	
	
	
	

	
	

}
