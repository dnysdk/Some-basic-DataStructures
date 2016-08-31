import java.util.*;
class Node{
	int data;
	Node next;
	Node(){
		this.data = 111111111;
		this.next = null;
	}
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Queue{
	int size = 0;
		

	Node head = null;
	Node tail = null;		
 	
 	void queue(int data){
 		Node newnode = new Node(data);
 		if(tail==null){
 			//System.out.println("before");
 			head = newnode;
 			tail = head;
 		}else{
 			//System.out.println("akd" + newnode.data);
 			//System.out.println(tail.data);
 			tail.next = newnode;
 			tail = newnode;
 			//System.out.println("after" + tail.data);
 		}
 		size++;
 	}

 	
 	// Node find(int value){
 	// 	if(head == null){
 	// 		return null;
 	// 	}
 	// 	Node node = head;
 	// 	while(node.data != value){
 	// 		node = node.next;
 	// 	}
 	// 	return node;
 	// }

 	int dequeue(){
 		Node node = head;
 		if(node!=null){
 			head = head.next;
 		}
 		return node.data;
 	}

 	void print(){

 		if(tail==null){
 			System.out.println("no item in link list");
 		}else{
 			Node node = head;
 			while(node!= null){
 				System.out.print(node.data);
 				if(node != tail){
 					System.out.print(" --> ");
 					
 				}
 				
 				node = node.next;
 			}
 			if(node!=null)
 				System.out.print(node.data);
 			System.out.println();
 		}
 		System.out.println();
 	}

 	// void reverse(){
 	// 	Node node = head;
 	// 	tail = head;
 	// 	Node next = null;
 	// 	Node prev = null;
 	// 	while(node !=null){
 	// 		next = node.next;
 	// 		node.next = prev;
 	// 		prev = node;
 	// 		node = next;
 	// 	}
 	// 	node = prev;
 	// 	head = node;
 	// }
}
class list{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue first = new Queue();
		first.print();
		first.queue(4);
		first.queue(8);
		first.queue(10);
		first.print();
		System.out.println(first.size);
		int a = first.dequeue();
		System.out.println(a);
		first.print();
		first.queue(12);
		first.print();
	}
}
