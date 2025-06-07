
public class StringManipulation {

	public static void main(String[] args) {
		
		String str = "My name is Sachin";
		String str2 = "My name is Bond";
		
		//Value of character at 5th index
		System.out.println(str.charAt(5)); 

		//Index of 'h'
		System.out.println(str.indexOf('h'));
		
		//String comparison
		System.out.println(str.equals(str2));
		
		//Substring -- exclude endIndex
		System.out.println(str.substring(0, 6));
		
		//replace
		String date = "22-11-2020";
		System.out.println(date.replace('-', '/'));
		
		//Split ---- very important
		String test = "hello_world_test_selenium";
		String [] testVal = test.split("_");
		for(String val:testVal) {
			System.out.println(val);
		}
			
	}

}
