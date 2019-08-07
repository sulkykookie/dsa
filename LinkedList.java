/*
Linked List implementation in Java
*/

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
		System.out.print("Enter the size of the Linked List: ");
		int n = Integer.parseInt(br.readLine());	//size of the linked list
		list l = new list();

		//input n integers and add them to the list
		System.out.println("Enter the elements of the Linked List: ");
		String[] s = br.readLine().trim().split("\\s+");
		for (int i=0; i<n; i++) {
			l.addNode(Integer.parseInt(s[i]));
		}

		System.out.print("Enter the number of queries: ");
		int q = Integer.parseInt(br.readLine());

		System.out.println("1 : Print the list \n2 x: Insert x in the end of the list");

		/*
		1: Prints the Linked List
		2 x: Adds the element x to the end of the list
		*/
		for (int i=0; i<q; i++) {
			s = br.readLine().trim().split("\\s+");
			int query = Integer.parseInt(s[0]);

			//Query Check
			if (query == 1)
				l.printList();
			else if (query == 2) {
				int param = Integer.parseInt(s[1]);	//parameter variable to the query
				l.addNode(param);
			}
		}
	}
}