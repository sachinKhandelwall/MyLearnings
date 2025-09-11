
public class MaximumSumOfSubarray_Imp {

	public static void main(String[] args) {
		
		 int[] arr = {-2, -3, -1, -10};
		//int[] arr = {2,3,4,-100,-5,1,-20,70};
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			sum = sum + arr[i];
			maxSum = Math.max(maxSum, sum);
			
			if(sum < 0) {
				sum = 0;
			}

		}
		
		System.out.println("Maximum sum of a subarray : "+ maxSum);

	}

}
