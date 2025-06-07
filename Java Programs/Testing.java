
public class Testing {

	public static void main(String[] args) {
		
		int[] arr = {13,1,45,2,35,10,1};

		// 2nd largest number
		int max = arr[0];
		int secondMax = arr[0];
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i] > secondMax && arr[i]<max) {
				secondMax = arr[i];
			}
		}
		
		 System.out.println(secondMax);

	}

}
