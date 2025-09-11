import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertArraytoList {
	public static void main(String[] args) {
		
		//for converting Array to ArrayList Integer[] type array to be used not as int[].
		Integer[] arr = {1,-12, 7, 9, 18, -56};
		
		//Method1
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);
 
		//Method2
		// if we want to modify the list then we should use this way to convert Array to ArrayList
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(arr));
		list2.add(555);
		System.out.println("List after adding a new number: "+list2);
	}
}
