import java.util.*;

class Node{
	int data;
	Node next;
	//Node(){
	//	this.data = 111111111;
	//	this.next = null;
	//}
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class linklist{
	int size = 0;
		

	Node head = null;
	Node tail = null;		
 	
 	void insert(int data){
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

 	void insertafter(int data, int value){
 		Node after = find(value);
 		//System.out.println("data" + after.data);
 		Node newnode = new Node(data);
 		if(after!=null){
 			newnode.next = after.next; 			
 			after.next = newnode;
 			size++;
 		}
 	}

 	Node find(int value){
 		if(head == null){
 			return null;
 		}
 		Node node = head;
 		while(node.data != value){
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

 	int swaplink(int data,int value){
 		Node first_node = find(data);
 		Node second_node = find(value);
 		Node first_node_pre = find_node_pre(data);
 		Node second_node_pre = find_node_pre(value);

 		if(first_node == null || second_node == null){
 			return 0;
 		}
 		
 		//System.out.println(first_node.data);
 		//System.out.println(second_node.data);
 		//System.out.println(first_node_pre.data);
 		//System.out.println(second_node_pre.data);
  			if(first_node_pre != null){
 				first_node_pre.next = second_node;
 			}else{
 				head = second_node;
 			}
 			if(second_node_pre != null){
 				second_node_pre.next = first_node;
 			}else{
 				head = first_node;
 			} 			

 			Node temp = first_node.next;
 			first_node.next = second_node.next;
 			second_node.next = temp;

 			return 1;
 	}

 	Node find_node_pre(int data){
 		Node node = head;
 		Node prev = null;
 		while(node!=null && node.data != data){
 			prev = node;
 			node = node.next;
 		}
 		return prev;
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

 	void reverse(){
 		Node node = head;
 		tail = head;
 		Node next = null;
 		Node prev = null;
 		while(node !=null){
 			next = node.next;
 			node.next = prev;
 			prev = node;
 			node = next;
 		}
 		node = prev;
 		head = node;
 	}
 	void linkdelete(int m,int n)
{
// Add code here    
    int count=0;
    Node first,second=null;
    Node temp = head;
    while(temp!=null){
        count++;
        if(count==m){
            count=0;
            first = temp;
            System.out.println(first.data);
  
                temp = temp.next;
            while(temp!=null){
                count++;
                if(count==n){
                    count=0;
                    if(temp.next!=null){
                        second = temp.next;
                        first.next = second;
                        System.out.println("dfd"+ second.data);
                        break;
                    }
                }
                temp = temp.next;
            }
            
        }
        if(temp!=null)
        temp = temp.next;
    }
}
void pairWiseSwap()
    {
          //  The task is to complete this method
    Node temp = head;
    Node n;
    int t=0;
    while(temp!=NULL || temp.next!=NULL){
       t=temp.data;
       n = temp.next;
       temp.data =  n.data;
       n.data = t;
       temp = n.next;
    }
}

}
class list{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		linklist first = new linklist();
		first.print();
		first.insert(4);
		first.insert(8);
		first.insert(10);
		first.print();
		System.out.println(first.size);
		first.insertafter(6,4);
		first.print();
		// first.delete(6);
		// first.print();
		int a = first.swaplink(4,6);
		if(a==0){
			System.out.println("ERROR");
		}else{
			first.print();
		}

		first.reverse();
		first.print();
		first.insert(12);
		first.insert(13);
		first.insert(14);
		first.insert(15);
		first.insert(16);
		first.insert(17);
		first.print();
		first.linkdelete(2,2);
		first.pairWiseSwap();
		first.print();
		first.print();
	}
}
