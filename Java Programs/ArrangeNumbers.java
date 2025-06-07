import java.util.Arrays;

public class ArrangeNumbers {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 0, -1, -6, 12, -12, 7, 9, 0, 0, 18, -56};
		int len = arr.length;
		int[] temp = new int[len];
		int j = 0;
		
		//Method1
		//Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		
		//Method2---using temp variable
		for(int i=0; i<len; i++) {
			if(arr[i]<0) {
				temp[j]=arr[i];
				j++;
			}	
		}
		for(int i=0; i<len; i++) {
			if(arr[i]>=0) {
				temp[j]=arr[i];
				j++;
			}	
		}
		
		System.out.println("After moving all negative numbers to beginning: "+Arrays.toString(temp));
 
	}
}
