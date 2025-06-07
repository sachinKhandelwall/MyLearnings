
public class SubArrays {

	public static void main(String[] args) {
		
		//int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int[] arr = {1, 2, 3};

		int l = arr.length;
		int i,j,k;
		
		for(i=0; i<l; i++) {
			for(j=i; j<l; j++) {
				for(k=i; k<=j; k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.println("");
			}
		}

	}

}
