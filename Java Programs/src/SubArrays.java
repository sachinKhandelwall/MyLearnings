
public class SubArrays {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4};
		
/* subarray will be like this:
 
		1 
		1 2 
		1 2 3 
		1 2 3 4 
		2 
		2 3 
		2 3 4 
		3 
		3 4 
		4 
		
 */

		int i,j,k;
		
		for(i=0; i <arr.length; i++) {
			for(j=i; j <arr.length; j++) {
				for(k=i; k <=j; k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.println("");
			}
		}

	}

}
