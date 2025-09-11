
public class IfArrayIsSorted {

	public static void main(String[] args) {
		
		//int[] arr = {13,1,45,2,35,10,1};
		//int[] arr = {13};
		int[] arr = {13,100,145,145,350,1000,1000};
		
		boolean sorted = true;
		
		for(int i=0; i< arr.length-1; i++) {
			
			if( (arr[i+1]-arr[i]) < 0 ) {
				sorted=false;
				break;			
			}
			
		}
		
		if(sorted) {
			 System.out.println("Array is sorted");
		}
		else {
			System.out.println("Array is not sorted");
		}
		 

	}

}
