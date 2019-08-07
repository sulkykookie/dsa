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

		this.size++;	//increase the size of the list by one
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

	//method to delete node present at index x(starting from 0)
	void deleteNode(int x) {
		//checks if the passed index is in the list; if not, the program terminates
		if (x>this.size-1){
			System.out.println("Index out of range");
			System.exit(0);
		}

		if (x==0)
			head = head.next;	//for the removal of the first elements; x=0
		else {
			node ptr = head;
			//traverse till the index previous to the passed index and attach that previous index to next of the next index
			for (int i=0; i<x-1; i++) {
				ptr = ptr.next;
			}
			ptr.next = ptr.next.next;
		}

		this.size--;	//decrease the size of the list by one

	}

	//method to modify data of a node present at index x(starting from 0) to data y
	void modifyNode(int x, int y) {
		//checks if the passed index is in the list; if not, the program terminates
		if (x>this.size-1){
			System.out.println("Index out of range");
			System.exit(0);
		}

		node ptr = head;
		for (int i=0; i<x; i++) {
			ptr = ptr.next;
		}
		ptr.data = y;

	}

}

public class LinkedList {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the size of the Linked List: ");
		int n = Integer.parseInt(br.readLine());	//size of the linked list
		list l = new list();

		//input n integers and add them to the list
		System.out.println("\nEnter the elements of the Linked List: ");
		String[] s = br.readLine().trim().split("\\s+");

		//Checks if the amount of entered number of elements is same as n; if not, the program terminates
		if (s.length < n  || s.length > n) {
			System.out.println("Inappropriate amount of elements");
			System.exit(0);
		}

		for (int i=0; i<n; i++) {
			l.addNode(Integer.parseInt(s[i]));
		}

		System.out.print("\nEnter the number of queries: ");
		int q = Integer.parseInt(br.readLine());

		/*
		1: Prints the Linked List
		2 x: Adds the element x to the end of the list
		3 x: Deletes the element at index x
		4 x y: Changes the value at index x to value y
		*/
		System.out.println("\n1 : Print the list \n2 x: Insert x in the end of the list \n3 x: Delete element at index x \n4 x y:Change value at index x to value y");

		for (int i=0; i<q; i++) {
			s = br.readLine().trim().split("\\s+");
			int query = Integer.parseInt(s[0]);

			//Query Check
			if (query == 1)
				l.printList();
			else if (query == 2) {
				int param = Integer.parseInt(s[1]);	//parameter variable to the query
				l.addNode(param);
			} else if (query == 3) {
				int param = Integer.parseInt(s[1]);
				l.deleteNode(param);
			} else if (query == 4) {
				int param1 = Integer.parseInt(s[1]);	//index parameter
				int param2 = Integer.parseInt(s[2]);	//new value parameter
				l.modifyNode(param1, param2);
			}
		}
	}
}