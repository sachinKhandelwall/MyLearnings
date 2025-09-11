
public class Pattern {

	public static void main(String[] args) {
		
//		12344321
//		123**321
//		12****21
//		1******1
		
		int n = 4;
		int i, j,k,l;
		
		for(i=1; i<=n; i++) {
			for(j=1; j<=n-i+1; j++) {
				System.out.print(j);
			}
			for(k=1; k< 2*i-1; k++) {
				System.out.print("*");
			}
			for(l=n-i+1; l>=1; l--) {
				System.out.print(l);
			}
			System.out.println();
		}

	}

}
