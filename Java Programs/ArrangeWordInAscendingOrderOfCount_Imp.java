import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrangeWordInAscendingOrderOfCount_Imp {

	public static void main(String[] args) {


		String str = "Java is Java and Java is amazing";
		String[] words = str.split(" ");
		
		Map<String, Integer> mp = new HashMap<String, Integer>();
		
		for(String w : words) {
			if(mp.containsKey(w))
				mp.put(w, mp.get(w) + 1);
			else
				mp.put(w, 1);
		}
		
//		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
//		
//		mp.entrySet().stream().forEach(entry -> list.add(entry));
//		System.out.println(list);
//		Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());
//		System.out.println("List after sorting based on count : "+list);
		
		mp.entrySet().stream().sorted((o1, o2) -> o1.getValue() - o2.getValue()).forEach(entry -> System.out.print(entry.getKey()+ " "));;

	}

}
