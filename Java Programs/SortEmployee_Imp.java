import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Player{	

	String name;
	int runs;
	
	public Player(String name, int runs) {
		this.name = name;
		this.runs = runs;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", runs=" + runs + "]";
	}

}
public class SortEmployee_Imp {

	public static void main(String[] args) {
		Player p1 = new Player("Tendulkar", 500);
		Player p2 = new Player("Kohli", 600);
		Player p3 = new Player("Yuvraj", 300);
		Player p4 = new Player("Devilliers", 800);
		
		List<Player> playersList = new ArrayList<Player>();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		playersList.add(p4);
		
		// Sort using stream 
		List<Player> sortedPlayersList = playersList.stream().sorted((o1, o2) -> o1.getRuns() - o2.getRuns()).collect(Collectors.toList());
		System.out.println("Method 1 Ascending order: "+sortedPlayersList);
		
		List<Player> sortedPlayersList2 = playersList.stream().sorted(Comparator.comparingInt(Player :: getRuns).reversed()).collect(Collectors.toList());
		System.out.println("Method 2 Descending order: "+sortedPlayersList2);
		
		List<Player> sortedPlayersList3 = playersList.stream().sorted(Comparator.comparing(Player :: getName).reversed()).collect(Collectors.toList());
		System.out.println("Method 2 Descending order by name: "+sortedPlayersList3);
		
		// Sort using Collections
		Collections.sort(playersList, (o1, o2) -> o1.getRuns() - o2.getRuns());
		System.out.println("Ascending order sorting using comparator: "+playersList);
		
		Collections.sort(playersList, (o1, o2) -> o2.getRuns() - o1.getRuns());
		System.out.println("Descending order sorting using comparator: "+playersList);
		
		
		
		

	}

}
