
public class SecondLargest {

	public static void main(String[] args) {

		     int[] arr = {1,0,14,12,3};
		     int i; 
		     int max=Integer.MIN_VALUE;
		     int secondMax=Integer.MIN_VALUE;
		     
		     for(i=0; i< arr.length; i++){
		    	 if(arr[i]>max) {
		    		 max=arr[i];
		    	 }
		     } 
		     
		     for(i=0; i< arr.length; i++){
		    	 if(arr[i]>secondMax && arr[i]<max) {
		    		 secondMax=arr[i];
		    	 }
		     } 
		     
		     System.out.println(secondMax);

	}

}
