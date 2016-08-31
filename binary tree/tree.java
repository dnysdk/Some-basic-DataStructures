import java.util.*;

class Queue<E>{
	int size = 0;
	class Node<T>{
	T data;
	Node<T> next;
	Node(){
		this.data = null;
		this.next = null;
	}
	Node(T data){
		this.data = data;
		this.next = null;
	}
}	

	Node<E> head = null;
	Node<E> tail = null;		
 	
 	void enqueue(E data){
 		Node<E> newnode = new Node<E>(data);
 		if(size==0){
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

 	E dequeue(){
 		Node<E> node = head;
 		if(node!=null){
 			head = head.next;
 			size--;
 			return node.data;
 		}
 		return null;		
 	}

 	E gethead(){
 		if(head!=null)
	 		return head.data;
	 	return null;
 	}
}
class Node{
	int data;
	Node left;
	Node right;
	Node(){
		this.data = 111111111;
		this.left = null;
		this.right = null;
	}
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Tree{
	
	Node root = null;
	void insert(int data){
		//Node temp = root;
		root = add(root,data);
	}
	Node add(Node node, int data){
		if(node==null){
			Node newnode = new Node(data);
			node = newnode;
			return node;
		}else{
			//System.out.println(node.data);
			if(node.data>data){
				node.left = add(node.left,data);
			}else{
				node.right = add(node.right,data);
			}
		}
		return node;
	}

	void inorder(){
		displayinorder(root);
		System.out.println();
	}

	void displayinorder(Node node){
		if(node!=null){
			//System.out.println(node.data);
			displayinorder(node.left);
			System.out.print(node.data + ",");
			displayinorder(node.right);
		}
		//return node;
	}

	void preorder(){
		displaypreorder(root);
		System.out.println();
	}

	void displaypreorder(Node node){
		if(node!=null){
			System.out.print(node.data + ",");
			displaypreorder(node.left);
			displaypreorder(node.right);
		}
	}

	void postorder(){
		displaypostorder(root);
		System.out.println();
	}

	void displaypostorder(Node node){
		if(node!=null){
			displaypostorder(node.left);
			displaypostorder(node.right);
			System.out.print(node.data + ",");
		}
	}
	Queue<Node> queue = new Queue<Node>();
	void bfs(){
		Node temp = root;
		queue.enqueue(temp);
		//Node node = queue.gethead();
		while(queue.size!=0){
			Node node = queue.dequeue();
			//System.out.println(queue.size);
			//System.out.println(node.left.data);
			if(node.left!=null)
				queue.enqueue(node.left);
			if(node.right!=null)
				queue.enqueue(node.right);
			if(node!=null)
				System.out.print(node.data + ",");
			//queue.dequeue();
			//node = queue.gethead();
		}
		System.out.println();
	}
}

class BinaryTree{
	public static void main(String[] args) {
		Tree sample = new Tree();
		sample.insert(5);
		sample.insert(3);
		sample.insert(2);
		sample.insert(4);
		sample.insert(8);
		sample.insert(6);
		sample.insert(10);
		sample.insert(1);
		sample.insert(0);

		sample.inorder();
		sample.preorder();
		sample.postorder();
		sample.bfs();
	}
}
