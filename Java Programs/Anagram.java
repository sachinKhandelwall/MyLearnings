import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String str1 = "sTop";
		String str2 = "POTS";
		
		char[] ch1 = str1.toLowerCase().toCharArray();
		char[] ch2 = str2.toLowerCase().toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(Arrays.equals(ch1, ch2)) {
			System.out.println("Two strings are anagram to each other.");
		}
		else
		{
			System.out.println("Strings are not anagram");
		}

	}

}
