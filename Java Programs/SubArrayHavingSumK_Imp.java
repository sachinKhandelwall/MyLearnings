
public class SubArrayHavingSumK_Imp {

	public static void main(String[] args) {
		
		//int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int[] arr = {1, 2, 3};
		int sum;
		int k = 5;

		int l = arr.length;
		int i,j;
		int start_index = 0;
		int end_index = 0;
		
		for(i=0; i<l; i++) {
			sum = 0;
			for(j=i; j<l; j++) {
				sum = sum + arr[j];
				if(sum==k) {
					start_index = i;
					end_index = j;
				}

			}
		}
		
		System.out.println("Subarray having sum = " + k);
		for(j= start_index; j<= end_index; j++) {
			System.out.print(arr[j] + " ");
		}

	}

}
