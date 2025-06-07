import java.util.Arrays;

public class AddNumberFromStrings_Imp {

	public static void main(String[] args) {
		
	    String str = "abc10def5ghi20jkl10";
//	    String number = "0";
//	    int sum = 0;
//	    char c;
//	    
//	    for(int i=0;i<str.length();i++){
//	    	c= str.charAt(i);
//	        if(Character.isDigit(c)){
//	        	number = number + c;
//	        }else{      
//	            sum = sum + Integer.valueOf(number);
//	            number = "0";
//	        }
//	    }
//	
//	        sum = sum + Integer.valueOf(number);
//	    
//	    System.out.println("Sum is: "+sum);
	    
	    //2nd method using regex
	    
	    String[] numArray = str.replaceAll("\\D+", " ").trim().split("\\s");
	    System.out.println(Arrays.toString(numArray));
	    int sum = 0;
	    for(String num : numArray) {
	    	sum = sum + Integer.valueOf(num);
	    }
	    System.out.println("Sum is: "+sum);
        
	}

	}


