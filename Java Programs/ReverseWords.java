
public class ReverseWords {

	public static void main(String[] args) {
		String str = "My name is Sachin";
		String rev = "";
		String [] words = str.split(" ");
		int len = words.length;
	
		for(int i= len-1; i>=0; i-- ) {
			rev = rev + words[i] + " " ;
		}
		System.out.println("Reverse of words is : "+rev); 

	}

}
