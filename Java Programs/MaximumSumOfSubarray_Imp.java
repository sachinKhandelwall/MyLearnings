
public class MaximumSumOfSubarray_Imp {

	public static void main(String[] args) {
		
	//	int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int[] arr = {2,3,4,-100,-5,1,-20,70};
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if(sum < 0) {
				sum = 0;
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println("Maximum sum of a subarray : "+ maxSum);

	}

}
