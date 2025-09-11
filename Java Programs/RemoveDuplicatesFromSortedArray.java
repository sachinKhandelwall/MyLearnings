import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String[] args) {
		
		int[] arr = {10,10,10,20,20,60,70,70,70};
		int j=0;
		
		//Output should be: {10,20,60,70}
		
		for(int i = 0; i< arr.length-1; i++) {
			
			if(arr[i] != arr[i+1]) {
				arr[j] = arr[i];
				j++;		
			}

		}
		
		arr[j] = arr[arr.length-1];
		
		int[] arr2 = Arrays.copyOf(arr, j+1);

        System.out.println("Array after removing duplicates: " + Arrays.toString(arr2));
		
			
	}

}
