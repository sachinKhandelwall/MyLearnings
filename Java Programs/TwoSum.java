import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] num = {1, 2, 3, 4};
		int sum = 7;
		int[] result = twoSum(num, sum);
		System.out.println("Indices: " + result[0] + " and " + result[1]);

	}
	
	public static int[] twoSum(int[] num, int targetSum) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i< num.length; i++) {
			int complement = targetSum - num[i];
			
			if(map.containsKey(complement)) {
				result[0] = map.get(complement);
				result[1] = i;
			} 
			
			map.put(num[i], i);
			
		}
			
		return result;	
	}

}
