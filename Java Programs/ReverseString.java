
public class ReverseString {
	
	public static void main(String[] args) {
		
	String str = "SACHIN";
	String rev = "";
	
	//METHOD 1
/*	int len = str.length();
	for(int i = len-1; i>=0; i--) {
		rev = rev + str.charAt(i);
	}
	
	System.out.println("Reverse of string str is : "+rev); 
	
	//Method 2 -- using character array
	char a[] = str.toCharArray();
	int len = a.length;
	for(int i = len-1; i>=0; i--) {
		rev = rev + a[i];
	}
	System.out.println("Reverse of string str is : "+rev);*/
	
	//Method 3 -- string buffer
	StringBuffer sb = new StringBuffer(str);
	System.out.println(sb.reverse());
	
	
}
}
