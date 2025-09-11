
public class SwapTwoString {
	
	public static void main(String[] args) {
		
		String s1 = "Sachin";
		String s2 = "Khandelwal";
		
		System.out.println("Before swapping: s1 = "+s1 +" and s2 = "+s2); 
		
		//Swap s1 & s2 without using 3rd variable
		
		s1 = s1+s2; //SachinKhandelwal
		
		s2 = s1.substring(0, s1.length() - s2.length()); // Sachin
		
		s1 = s1.substring(s2.length()); // Khandelwal
		
		System.out.println("Before swapping: s1 = "+s1 +" and s2 = "+s2); 

	}

}
