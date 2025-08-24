import java.util.Arrays;

public class MoveAllZerosAtEnd {
	
	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 0, 0, 12, 0, 7, 9, 0, 0, 18, 0};
		int l = arr.length;
		int count=0;
		
		for(int i=0; i<l; i++) {
			if(arr[i] !=0) {
				arr[count] = arr[i];
				count++;
			}
		}
		
		for(int i=count; i<l; i++) {
				arr[i] = 0;
			}
		
	System.out.println("After moving all zeros at the end: "+Arrays.toString(arr));
		
	}
}
