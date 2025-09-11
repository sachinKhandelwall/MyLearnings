import java.util.Arrays;

public class MaximumDifference {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 100, 51, 2, 3, 5};
		int min, max, diff;
		int len = arr.length;
		
		//Method1- sort the array - min will be the first element and max will be the last
	/*	Arrays.sort(arr);
		System.out.println(arr[5]);
		min = arr[0];
		max = arr[len-1];
		diff = max-min;
		System.out.println("Maximum difference between 2 elements: "+diff);
		*/
		
		//Method2 - find min and max element using for loops
		min = arr[0];
		max = arr[0];
		for(int i=0; i<len; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		diff = max-min;
		System.out.println("Maximum difference between 2 elements: "+diff);

	}

}
