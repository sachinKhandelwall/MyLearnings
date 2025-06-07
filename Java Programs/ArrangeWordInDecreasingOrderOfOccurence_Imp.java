import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrangeWordInDecreasingOrderOfOccurence_Imp {

	public static void main(String[] args) {
		
		String str = "My name is sachin and sachin is sachin is and is";
		
		String[] words = str.split(" ");
		
		Map<String, Integer> mp = new HashMap<String, Integer>();
		
//		for(String w: words) {
//			if(mp.containsKey(w)) {
//				mp.put(w, map.get(w) + 1);
//			} else {
//				mp.put(w, 1);
//			}
//		}
//		
//		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
//		
//		map.entrySet().stream().forEach(entry -> list.add(entry));
//		
//		Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
//		System.out.println(list.toString());
		
		//method 2
		for(String w : words) {
			mp.put(w, mp.getOrDefault(w, 0)+ 1 );// if a get does not exist then getOrDefault method returns default value i.e, 0
		}
		
		mp.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(entry -> System.out.print(entry.getKey()+ " "));;

		
		

	}

}
