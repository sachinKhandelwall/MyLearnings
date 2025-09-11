import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
	
	
	public static boolean isValidAnagram(String s, String t) {
		
		if(s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c : t.toCharArray()) {
			
			if(!map.containsKey(c)) {
				return false;
			}
			
			map.put(c, map.get(c) - 1);
			
			if(map.get(c) == 0) {
				map.remove(c);
			}
			
		}	
		
		return true;
	}
	

	public static void main(String[] args) {
		
		String str1 = "anagram";
		String str2 = "nagaram";
		
		boolean anagram = isValidAnagram(str1, str2);
		
		if (anagram) {
		    System.out.println("Two strings are anagram to each other.");
		} else {
		    System.out.println("Not Anagram");
		}
	
		
//		char[] ch1 = str1.toLowerCase().toCharArray();
//		char[] ch2 = str2.toLowerCase().toCharArray();
//		Arrays.sort(ch1);
//		Arrays.sort(ch2);
//		if(Arrays.equals(ch1, ch2)) {
//			System.out.println("Two strings are anagram to each other.");
//		}
//		else
//		{
//			System.out.println("Strings are not anagram");
//		}

	}

}
