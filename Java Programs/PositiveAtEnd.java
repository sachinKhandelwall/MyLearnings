
public class PositiveAtEnd {

	public static void main(String[] args) {
		
		int[] arr = {-1,5,0,-3,0,8,12,-9};
		int count =0;
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>0) {
				arr[count]=arr[i];
				count++;
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]<=0) {
				arr[count]=arr[i];
				count++;
			}
		}
		
		for(int i =0 ; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		

	}

}
