package List;

public class AADoublyLinkedList {
	
	int size = 0;
	Node tail;
	Node head;
	
	AADoublyLinkedList() {
		head = tail = new Node();		
	}
	
	class Node {
		int data;
		Node next;
		Node pre;
	}
		
	private void add(int data) {
		Node nn = new Node();
		nn.data = data;	

		if (size == 0) {
			head = tail = nn;
			size++;
			return;
		}
			
		nn.next = head;
		head.pre = nn;
		head = nn;
		size++;
	}
	
	private void addAtLast(int data) {
		Node nn = new Node();
		nn.data = data;	

		if (size == 0) {
			head = tail = nn;
			size++;
			return;
		}
				
		tail.next = nn;
		nn.pre = tail;
		tail = nn;
		size++;
	}
	
	private void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " , ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		AADoublyLinkedList ll = new AADoublyLinkedList();
		ll.addAtLast(2);
		ll.addAtLast(3);
		ll.addAtLast(4);
		ll.add(1);
		ll.print();
	}
}
