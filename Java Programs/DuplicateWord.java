import java.util.HashSet;
import java.util.Set;

public class DuplicateWord {

	public static void main(String[] args) {
		
		String str = "Java is Java and Java is is the best";
		int count = 1;
		String [] words = str.split(" ");
		Set<String> set = new HashSet<String>();
		
		for(String word : words) {
			if(set.add(word) == false) {
				count++;
				System.out.println("Duplicate word is :"+word);
			}
		}
		System.out.println("Number of duplicate word :"+ count);

	}

}
