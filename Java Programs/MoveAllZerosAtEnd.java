import java.util.Arrays;

public class MoveAllZerosAtEnd {
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 0, 0, 12, 0, 7, 9, 0, 0, 18, 0};
		int len = arr.length;
		int[] temp = new int[len];
		int j = 0;
		
		for(int i=0; i<len; i++) {
			if(arr[i]>0) {
				temp[j]=arr[i];
				j++;
			}	
		}
		
		//Can use this also
	/*	for(int i=0; i<len; i++) {
			if(arr[i]==0) {
				temp[j]=arr[i];
				j++;
			}	
		}*/
		
		while(j<len) {
			temp[j]=0;
			j++;
		}
		
		System.out.println("After moving all zeros at the end: "+Arrays.toString(temp));
 
	}
}
