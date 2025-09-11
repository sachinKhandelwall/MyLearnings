import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondMostRepeatedWord_Imp {
	
	public static void main(String[] args) {
		
		//2nd most repeated word
		String str = "aaa bbb ccc aaa bbb bbb bbb aaa"; //Output aaa
		
		String[] words = str.split(" ");
		
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		
		for(String key : words) {
			mp.put(key, mp.getOrDefault(key, 0) + 1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>> ();
		mp.entrySet().stream().forEach(entry -> list.add(entry));
		
		//1st approach: Sort in ascending order and get 2nd last index for 2nd most repeated word
		Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
		System.out.println("Second most repeated word is: "+list.get(list.size()-2).getKey());
		
		//2nd approach: Sort in descending order and get 1st index for 2nd most repeated word
		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
		System.out.println("Second most repeated word is: "+list.get(1).getKey());
		
		
		//3rd approach without using any list
		String secondMost = mp.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
				.skip(1) //skip(n) skip the 1st n element of the stream
				.findFirst()
		        .map(entry -> entry.getKey())
		        .orElse(null);
		System.out.println("Second most repeated word without using list is: "+secondMost);

			
	}

}
