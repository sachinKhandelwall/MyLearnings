
public class ReverseWithoutAffectingSpecialChars_Imp {

	public static void main(String[] args) {
		
//		String str = "#s@a!c+h=I**n";  //Output = #n@I!h+c=a**s
//		
//		char[] arr = str.toCharArray();
//		int j=0;
//		int k = str.length()-1;
//		char temp;
//		
//		while(j<k) {
//			
//			if(!Character.isAlphabetic(arr[j])) {
//				j++;
//			}
//			
//			if(!Character.isAlphabetic(arr[k])) {
//				k--;
//			}
//			
//			if(Character.isAlphabetic(arr[j]) && Character.isAlphabetic(arr[k])) {
//				temp = arr[j];
//				arr[j] = arr[k];
//				arr[k] = temp;
//				j++;
//				k--;
//			}
//		}
//		
//		System.out.println("String after reversing and preserving the special chars : ");
//		for(char c : arr) {
//			System.out.print(c);
//		}
	
		// 2nd method
		
		String str = "#s@a!c+h=I**n";  //Output = #n@I!h+c=a**s
		
		int len = str.length()-1;
		int j = len;
		int i = 0;
		String rev = "";
		
		for(i=0; i<=len; i++) {
			
			if(Character.isAlphabetic(str.charAt(i))) {
				
				while(!Character.isAlphabetic(str.charAt(j))) {
					j--;
				}
				rev = rev + str.charAt(j);
				j--;
				
			}
			else {
				rev = rev + str.charAt(i);
			}
		}
		
		System.out.println("String after reversing and preserving the special chars : "+rev);
		

	}

}
