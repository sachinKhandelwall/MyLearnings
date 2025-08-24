
public class Palindrome {

	public static void main(String[] args) {
		
		int n = 1221;
		int temp = n;
		int rev = 0;
		int rem;
		
		while(n > 0) {
			rem = n%10;
			rev = rev*10 + rem;
			n = n/10;	
		}
		
		if(rev == temp) {
			System.out.println("Number is Palindrome"); 
		}
		else {
			System.out.println("Number is NOT Palindrome") ;
		}
		
		//Sum of digit
		int num = 12348;
		int sum = 0;
		int remm;
		
		while(num > 0) {
			remm = num%10;
			sum = sum + remm;
			num = num/10;		
		}
		
		System.out.println("Sum of digits : "+ sum) ;
		

	}

}
