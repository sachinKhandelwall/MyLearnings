package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class First_Negative_Num_in_subArrays_size_K_brute {
	
	
	public static void main(String[] args) {
		
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		
		// Output:  [-1, -1, -7, -15, -15, 0] 
		// Return 1st negative number in each subArray of size and return 0 if no negative number found in a subArray
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<= arr.length - k; i++) {
			boolean firstNegFound = false;
			
			for(int j=i; j< i+k; j++) {	
				if(arr[j] < 0) {
					firstNegFound = true;
					list.add(arr[j]);
					break;
				}		
			}
			
			if(firstNegFound==false) {
				list.add(0);
			}
			
		}
		

		System.out.println("List of 1st Negative Number in SubArray of size K: "+list);

	}
	
	
	
	

	
	

}
