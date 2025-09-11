
public class SubArrayHavingMaxSum_Imp {

	public static void main(String[] args) {
		
		//int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int[] arr = {2,3,66,-100,-5,1,-20,70,-2,15};
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int start_index = 0;
		int end_index = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			
			if(sum < 0) {
				sum = 0;
				start_index = i+1; // updating start_index every time sum < 0, assuming that's the start of a potential new subArray
			}
			
			if(sum > maxSum) {
				maxSum = sum;
				end_index = i;
			}
				
		}
		
		System.out.println("Subarray having maximum sum : ");
		
		for(int j= start_index; j<= end_index; j++) {
			System.out.print(arr[j] + " ");
		}

	}

}
