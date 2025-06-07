
public class ReverseAndPreserveSpace {

	public static void main(String[] args) {
		
	      String str = "I am boy"; //Output y ob maI
	      int len = str.length()-1;
	      int j = len;
	      String rev = "";
	      
	     for(int i = 0; i <= len; i++) {
	    	 if(str.charAt(i) != ' ') {
	    		 while(str.charAt(j) == ' ') {
	    			 j--;
	    		 }
	    		 rev = rev + str.charAt(j);
	    		 j--;
	    	 }
	    	 else {
	    		 rev = rev + str.charAt(i);
	    	 }
	    	 
	     }
	     
	     System.out.println("Reverse after Preserving space : "+rev.trim());
	}

}

