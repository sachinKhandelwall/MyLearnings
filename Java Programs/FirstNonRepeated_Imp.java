
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeated_Imp {

	public static void main(String[] args) {

		String str = "Sachin is my name is Sachin"; //Output should be "my"
		String[] words = str.split(" ");
		
		Map<String, Integer> mp = new LinkedHashMap<String, Integer>();
		
		for(String w : words) {
			if(mp.containsKey(w)) {
				mp.put(w, mp.get(w)+1);
			}
			else
			{
				mp.put(w, 1);
			}
		}
		
		for(String key : mp.keySet()) {
			if(mp.get(key) == 1) {
				System.out.println(key+ " is first non-repeated element "+mp.get(key));
				break;
			}
		}
	}

}
