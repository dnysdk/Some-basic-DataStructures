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

class list{
	int size = 0;
	class Node{
	int data;
	int key;
	Node next;
	Node right;
	Node(){
		//this.key =
		//this.data = 111111111;
		this.next = null;
		this.right = null;
	}
	Node(int key,int data){
		this.key = key;
		this.data = data;
		this.next = null;
		this.right = null;
	}
}	

	Node head = null;
	Node tail = null;		
 	
 	void insertnode(int key,int data){
 		Node newnode = new Node(key,data);
 		if(tail==null){
 			//System.out.println("before");
 			head = newnode;
 			tail = head;
 		}else{
 			tail.next = newnode;
 			tail = newnode;
 			//System.out.println("after" + tail.data);
 		}
 		size++;
 	}

 	void insertedge(int key1,int key2){
 		Node temp = find(key1);
 		Node temp1 = find(key2);
 		Node temp2 = new Node(temp1.key,temp1.data);
 		while(temp.right!=null){
 			temp = temp.right;
 		}

 		temp.right = temp2;
 	}


 	Node find(int value){
 		if(head == null){
 			return null;
 		}
 		Node node = head;
 		while(node.key != value){
 			node = node.next;
 		}
 		return node;
 	}

 	void delete(int value){
 		Node node = head;
 		if(node!=null){
 			if(node.data == value){
 				head = head.next;
 			}else{
 				while(node!=null){
 					Node temp = node;
 					node = node.next;
 					if(node.data == value){
 						temp.next = node.next;
 						node.next = null;
 						break;
 					}
 				}
 			}
 		}
 	}


 	void print(){

 		if(tail==null){
 			System.out.println("no item in link list");
 		}else{
 			Node node = head;
 			while(node!= null){
 				Node newnode = node;
 				while(newnode.right!=null){
 					System.out.print(newnode.data + "-->");
 					newnode = newnode.right;
 				}
 				System.out.print(newnode.data);
 				System.out.println();
 				node = node.next;
 			}
 			
 		}
 		System.out.println();
 	}

 	void dfs(){
 		boolean visited[] = new boolean[this.size+1];
 		int i = 0;
 		Node node = head;
 		while(node!=null){
 			if(visited[node.key] == false){
 				dfs_visit(visited,node);
 			}	
 			node = node.next;
 		}
 	}

 	void dfs_visit(boolean visited[],Node node){
 		visited[node.key] = true;
		System.out.print(node.key + ",");
		while(node!=null){
			if(visited[node.key] == false){
				dfs_visit(visited,node);
			}
			node = node.right;
		} 		
 	}

 	void bfs(){
 		Queue<Node> queue = new Queue<Node>();
 		Node node = head;
 		boolean visited[] = new boolean[this.size+1];
 		queue.enqueue(node);
 		while(queue.size!=0){
 			Node temp = queue.dequeue();
 			temp = find(temp.key);
 			while(temp!=null){
 				if(visited[temp.key] == false){
 					visited[temp.key] = true;
 					System.out.println(temp.key + ",");
 					queue.enqueue(temp);
 				}	
 				temp = temp.right;	
 			} 			
 		}
 	}
}
class graph{
	public static void main(String[] args) {
		list g = new list();
		int i = 1;
		g.insertnode(i,10);
		i++;
		g.insertnode(i,11);
		i++;
		g.insertnode(i,12);
		i++;
		g.insertnode(i,13);
		i++;
		g.insertedge(1,2);
		g.insertedge(2,3);
		g.insertedge(3,4);
		g.insertedge(4,1);
		g.insertedge(4,2);
		g.insertedge(2,4);
		g.print();
		System.out.println();
		g.dfs();
		System.out.println();
		g.bfs();
	}
}