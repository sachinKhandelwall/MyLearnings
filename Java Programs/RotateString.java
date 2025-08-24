class Rotate{
	
	public void rotatedString(String str, int num) {
		//diain
		
		String rotated =  str.substring(num-1, str.length()) + str.substring(0, num-1) ;
		
		System.out.println(rotated);
	}
}

public class RotateString {

	public static void main(String[] args) {


		String str = "india";
		int n = 3;
		
		Rotate r = new Rotate();
		r.rotatedString(str, n);
	}

}
