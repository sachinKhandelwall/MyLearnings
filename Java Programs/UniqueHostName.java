import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class UniqueHostName {
	
	public static void main(String[] args) {
	
		String[] arr = {"sam@gmail.com", "ram@hotmail.com", "sa@gmail.com", "rsd@hotmail.com", "pr@info.co.in", "dk@rediffmail.com"};
		ArrayList<String> mailList = new ArrayList<String>(Arrays.asList(arr));
		System.out.println("Mail List : "+mailList); 
		
		HashSet<String> set =  new HashSet<String>();
		
		for(String mailId: mailList) {
			String hostName = mailId.substring(mailId.indexOf('@')+1).split("\\.")[0];
			System.out.println("Host List : "+hostName); 
			set.add(hostName);
		}
		
		System.out.println("Unique Host Name : "+set); 

	}

}
