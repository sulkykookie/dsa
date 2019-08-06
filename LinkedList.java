import java.io.*;

class node {
	int data;
	node next;

	node(int n) {
		this.data = n;
		this.next = null;
	}
}

class list {
	node head;
	int size;

	list() {
		this.head = null;
		this.size = 0;
	}

	//method to add a node to the end of the linked list
	void addNode(int n) {
		node temp = new node(n);
		if (head==null) {
			head = temp;
		} else {
			node ptr = head;
			while(ptr.next!=null) {
				ptr = ptr.next;
			}
			ptr.next = temp;
		}

		this.size++;
	}

	//method to print the list
	void printList() {
		node ptr = head;
		while(ptr!=null){
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}

public class LinkedList {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	//size of the linked list
		list l = new list();

		//input n integers and add them to the list
		String[] s = br.readLine().trim().split("\\s+");
		for (int i=0; i<n; i++) {
			l.addNode(Integer.parseInt(s[i]));
		}

		//printing the list
		l.printList();
	}
}