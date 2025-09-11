
public class DigitAtStartAndAlphabetsAtEnd {

	public static void main(String[] args) {
		
        String str= "asd14sd67fgh007";
        
        //Method1
        String correctedString = str.replaceAll("\\D", "") + str.replaceAll("\\d", "");
        System.out.println("String with Digit at the start and alphabet at the end is : "+correctedString);
        
        //Method2
        char[] input = str.toCharArray();
        StringBuilder digit = new StringBuilder();
        StringBuilder alphabet = new StringBuilder();
        
        for(char ch: input) {
        	if(Character.isDigit(ch)) {
        		digit.append(ch);
        	}
        	if(Character.isAlphabetic(ch)) {
        		alphabet.append(ch);
        	}
        }
        
        StringBuilder digitAtStart = digit.append(alphabet);
        System.out.println("Digit at the start: "+digitAtStart);

	}

}
