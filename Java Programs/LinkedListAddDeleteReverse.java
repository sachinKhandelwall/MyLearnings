

class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
}

class LinkedList {
	Node head;
	
	public void insertNode(int data) {
		
		if(head == null) {
			head = new Node(data);
		}
		
		else {
			Node curr = head;
			
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = new Node(data);		
			
		}	
	}
	
	
	public void insertNodeAtFirst(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;		
		System.out.println("\nAdded node at start: ");
	}
	
	
	public void insertNodeAtAnyIndex(int index, int data) {
		
		if(index == 0) {
			insertNodeAtFirst(data);
		}
		
		else {
			int count = 0;
			Node curr = head;
			Node temp = new Node(data);
			
			while(count < index-1) { //3rd index par add krna to 2nd index to traverse krenge
				curr = curr.next;
				count++;		
			}
			
			temp.next = curr.next;
			curr.next = temp;		
		}
		
		System.out.println("\nAdded node at a particular index: ");
	
	}
	
	
	public void removeFirstNode() {
		
		if(head.next == null) {
			head = null;
		}
		
		else {
			Node curr = head;
			head = head.next;
			curr.next = null;
		}
		
		System.out.println("\nRemoved first node: ");

	}
	
	
	public void removeLastNode() {
		
		if(head.next == null) {
			head = null;
		}
		
		else {
			Node curr = head;
			
			while(curr.next.next != null) { // to reach at the node before last node
				curr = curr.next;		
			}
			
			curr.next = null;
		}
		
		System.out.println("\nRemoved last node : ");
	}
	
	public void removeNodeAtAnyIndex(int index) {
		
		if(index == 0) {
			removeFirstNode();
		}
		
		else {
			int count = 0;
			Node curr = head;
			
			while(count < index-1) { //3rd index delete krna hai to 2nd index tak traverse krenge
				curr = curr.next;
				count++;		
			}
			
			Node temp = curr.next;
			curr.next = temp.next;
			temp.next = null;
					
		}
		
		System.out.println("\nRemoved node from a particular index: ");
	
	}
	
	
	public void traverseLinkedList() {
		Node curr = head;
		
		while(curr != null) {
			System.out.print(curr.data +" ");
			curr  = curr.next;		
		}
		
	}
	
	public void reverseLinkedList() {
		
		Node curr = head;
		Node prev = null;
		
		while(curr != null) {
			Node nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;		
		}
		head = prev;
		
		System.out.println("\nReversed Linked List: ");

	}
	
}


public class LinkedListAddDeleteReverse {
	
	public static void main(String[] args) {
		
		LinkedList linkedList  = new LinkedList();
		
		linkedList.insertNode(5);
		linkedList.insertNode(10);
		linkedList.insertNode(15);
		linkedList.insertNode(20);
		linkedList.traverseLinkedList();
		
		linkedList.insertNodeAtFirst(100);
		linkedList.traverseLinkedList();
		
		linkedList.insertNodeAtAnyIndex(3, 2000);
		linkedList.traverseLinkedList();
		
		linkedList.removeNodeAtAnyIndex(3);
		linkedList.traverseLinkedList();
		
		linkedList.removeFirstNode();
		linkedList.traverseLinkedList();
		
		linkedList.removeLastNode();
		linkedList.traverseLinkedList();
		
		
		linkedList.reverseLinkedList();
		linkedList.traverseLinkedList();

	}

}
