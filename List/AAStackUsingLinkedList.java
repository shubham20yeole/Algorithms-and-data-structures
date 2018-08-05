package List;

public class AAStackUsingLinkedList {

	int size;
	Node head;
	Node tail;
	
	AAStackUsingLinkedList() {
		this.size = 0;
		this.head = this.tail = new Node();
	}
	
	
	class Node {
		int data;
		Node next;
		Node pre;
	}

	private void push(int data) {
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
	
	private int pop() {
		int res = tail.data;
		tail = tail.pre;
		tail.next = null;
		return res;
	}
	
	private void print() {
		Node temp = head;
		
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		AAStackUsingLinkedList sul = new AAStackUsingLinkedList();
		
		sul.push(1);
		sul.push(3);
		sul.push(2);
		
		sul.print();
		
		System.out.println(sul.pop());
		sul.print();

	}

}
