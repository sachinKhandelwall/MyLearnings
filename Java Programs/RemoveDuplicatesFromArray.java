import java.util.Arrays;

public class RemoveDuplicatesFromArray {
	
	public static void main(String[] args) {
		
		int[] arr = {2,4,0,2,55,4,2,0,9,15,55,4,2,6};
		int[] arr2 = new int[arr.length];
		int k,l=0;
		
		//Output should be: {2,4,0,55,9,15,6}
		
		for(int i=0; i< arr.length; i++) {
			k=arr[i];
			boolean duplicate = false;
			
			for(int j=0; j<arr2.length; j++) {
				if(k==arr2[j]) {
					duplicate = true;
					break;	
				}	
			}
			
			if(duplicate==false) {	
				arr2[l]=k;
				l++;	
			}

		}
		
		System.out.println(l);
		
		// Trim array to actual size
		int[] arrayAfterRemovingDuplicates = Arrays.copyOf(arr2, l);
		System.out.print("Array after removing duplicates: " + Arrays.toString(arrayAfterRemovingDuplicates));
			
	}

}
