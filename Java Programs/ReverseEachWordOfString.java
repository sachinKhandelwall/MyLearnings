
public class ReverseEachWordOfString {
	
	public static void main(String[] args) {
		
		String str = "My name is Sachin"; //Output yM eman si nihcaS
		String rev = "";
		String [] words = str.split(" ");

		for(String word : words) {
			StringBuffer sb = new StringBuffer(word);
			rev = rev + sb.reverse().toString() + " ";
		}
		System.out.println("Reverse of words is : "+rev.trim()); 			
	}
}
