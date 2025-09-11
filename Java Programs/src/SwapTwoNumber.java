
public class SwapTwoNumber {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		System.out.println("Before swapping: a = "+a +" and b = "+b); 
		
		//Swap a & b without using 3rd variable
		
		a = a + b; // a = 30
		 
		b = a - b; // b = 10
		
		a = a - b; // a = 20
	
		
		System.out.println("After swapping: a = "+a +" and b = "+b); 

	}

}
