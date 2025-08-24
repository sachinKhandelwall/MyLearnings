package slidingWindow;



public class Max_SubArray_Sum_of_Size_k {
	
	
	public static void main(String[] args) {
		
		//int arr[] = {-2, -1, -5, -1, -3, -2};
		int arr[] = {2, 1, 5, 1, 3, 2};
		int k = 3;
		
		//output:  9 - SubArray with maximum sum is [5, 1, 3].
		
		
		int windowSum=0;
		int maxSum;
		
		for(int i=0; i< k; i++) {
			windowSum = windowSum + arr[i];
		}
		
		maxSum = windowSum;
		
		for(int i= 1; i<= arr.length - k; i++) {
			windowSum = windowSum + arr[i+k-1] - arr[i-1];
			maxSum = Math.max(maxSum, windowSum);
		}
		
		System.out.println("Maximum SubArray Sum of K size window is: "+maxSum);

	}
	
	
	
	

	
	

}
