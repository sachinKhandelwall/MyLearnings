
public class CountAllNumbersThatEndsWithZeroFromString_Imp {

	public static void main(String[] args) {
		
		String str = "505005000"; // 50+500+5000
		String num = "";
		int sum = 0;
		
		for(int i=0; i< str.length(); i++) {
			num = num + str.charAt(i);
			
			if(str.charAt(i)=='0' && (i==str.length()-1 ||str.charAt(i+1)!='0')) {
				sum = sum + Integer.valueOf(num); //sum = 50
				num = "";
			}
		}
		
		System.out.println(sum);
		
		//i==str.length()-1 this is added because if index is at last then checking i+1 will throw indexOutOfBound exception as string is ended




	}

}
