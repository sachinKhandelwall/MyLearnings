import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondMostRepeatedWord {
	
	public static void main(String[] args) {
		
		String str = "aaa bbb ccc aaa bbb bbb bbb aaa"; //Output aaa
		int max=0, secondMax=0;
		String[] words = str.split(" ");
		
		Map<String, Integer> mp = new HashMap<String, Integer>();
		for(String word : words) {
			if(mp.containsKey(word)) {
				mp.put(word, mp.get(word)+1);
			}
			else
				mp.put(word, 1);
		}
		
		for(String word : mp.keySet()) {
			int v = mp.get(word);
			if(v > max) {
				secondMax = max;
				max=v;
			}
			else {
				secondMax=v;
			}
			
		}
		
		for(String word : mp.keySet()) {
			if(mp.get(word) == secondMax) {
				System.out.println(word+ " is second most repeated element having occurrence count is : "+mp.get(word));
				break;
			}
		}
		
		//2nd approach
//		String str = "aaa bbb ccc aaa bbb bbb bbb aaa"; //Output aaa
//		
//		String[] words = str.split(" ");
//		
//		HashMap<String, Integer> mp = new HashMap<String, Integer>();
//		
//		for(String key : words) {
//			mp.put(key, mp.getOrDefault(key, 0) + 1);
//		}
//		
//		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>> ();
//		mp.entrySet().stream().forEach(entry -> list.add(entry));
//		Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
//		System.out.print("Second most repeated word is: "+list.get(list.size()-2).getKey());
		
		
		
	}

}
