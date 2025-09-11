import java.util.Arrays;

public class ReverseMainArray {
	
	public static void reverseArray(int[] arr) {
			
		int low = 0;
		int high= arr.length - 1;
		int temp=0;
		
		while(low < high) {
			temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
			low++;
			high--;		
		}
		
		System.out.println("Reverse Array: " + Arrays.toString(arr));
		
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {2,6,9,0,1,8};
		int arr2[] = {66,88,0,9,60};
		int arr3[] = {5};
		
		reverseArray(arr1);
		reverseArray(arr2);
		reverseArray(arr3);
		
	}	
	
}
