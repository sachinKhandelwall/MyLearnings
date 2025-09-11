
public class ReverseAndPreserveSpace {

	public static void main(String[] args) {
		
	      String str = "I am boy"; //Output y ob maI
	      
	      char[] arr = str.toCharArray();
	      int low = 0;
	      int high = str.length()-1;
	      char temp;
			
			while(low < high) {
				
				if(Character.isAlphabetic(arr[low]) && Character.isAlphabetic(arr[high])) {
					temp = arr[low];
					arr[low] = arr[high];
					arr[high] = temp;
					low++;
					high--;
				}
				
				if(!Character.isAlphabetic(arr[low])) {
					low++;
				}
				
				if(!Character.isAlphabetic(arr[high])) {
					high--;
				}
				
			}
			
			System.out.println("String after reversing and preserving the special chars : ");
			for(char c : arr) {
				System.out.print(c);
			}
	}

}

