import java.util.*;

class Stack{
	int size = 0;
	class Node{
	char opr;
	int data;
	Node next;
	Node(){
		this.data = 11111111;
		this.opr  = 'a';
		this.next = null;
	}
	Node(int data){
		this.data = data;
		this.opr = 'a';
		this.next = null;
	}
	Node(char c){
		this.data = 111111111;
		this.opr = c;
		this.next  = null;
	}
}	

	Node top = null;		
 	
 	void push(int data){
 		Node newnode = new Node(data);
 		Node temp;
 		if(top==null){
 			//System.out.println("before");
 			top = newnode;
 		}else{
 			//System.out.println("akd" + newnode.data);
 			temp = top;
 			newnode.next = temp;
 			top = newnode;
 			//System.out.println("after" + tail.data);
 		}
 		size++;
 	}

 	void push(char data){
 		Node newnode = new Node(data);
 		Node temp;
 		if(top==null){
 			//System.out.println("before");
 			top = newnode;
 		}else{
 			//System.out.println("akd" + newnode.data);
 			temp = top;
 			newnode.next = temp;
 			top = newnode;
 			//System.out.println("after" + tail.data);
 		}
 		size++;
 	}

 	int popdata(){
 		Node node = top;
 		if(node!=null){
 			top = node.next;
 		}
 		size--;
 		if(node == null){
 			return -11111111;
 		}
 		return node.data;
 	}

 	char popchar(){
 		Node node = top;
 		if(node!=null){
 			top = node.next;
 		}
 		size--;
 		if(node == null){
 			return 'n';
 		}
 		return node.opr; 		
 	}

 	void print(){

 		if(top==null){
 			System.out.println("no item in link list");
 		}else{
 			Node node = top;
 			while(node!= null){
 				System.out.print(node.data);
 				System.out.print(node.opr);
 				if(node != null){
 					System.out.print(" --> ");
 				}
 				
 				node = node.next;
 		 	}
 		// 	if(node!=null)
 		// 		System.out.print(node.data);
 		// 	System.out.println();
 		// }
 		System.out.println();
 	}
 }

}

class list{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack first = new Stack();
		first.print();
		String s = in.nextLine();
		int i;
		char c = '@';
		s = Character.toString(c) + s + Character.toString(c) ;
		String temp = "";
		for(i=s.length()-1;i>=0;i--){
			
			if(s.charAt(i)!='+' && s.charAt(i)!='/' && s.charAt(i)!='*' && s.charAt(i)!='-' && s.charAt(i)!='@'){
				temp = "";
				//System.out.println(s.charAt(i+1));
				while(s.charAt(i)!='+' && s.charAt(i)!='/' && s.charAt(i)!='*' && s.charAt(i)!='-' && s.charAt(i)!='@'){
					temp = Character.toString(s.charAt(i)) + temp;
					i--;
				//	System.out.println(temp);
				}
				//System.out.println("gyfg0" + temp);
				int var = Integer.parseInt(temp);
				first.push(var);	
			}
			first.push(s.charAt(i));
		}
		//first.print();
		char terminate = 'q';
		Stack result = new Stack();
		Stack sign = new Stack();
		first.popchar();
		int t = first.popdata();
		char current = '+';
		char newchar;
		terminate = first.popchar();
		while(terminate != '@'){
			result.push(t);
			if(terminate == '*'){
				t = result.popdata()*first.popdata();
				terminate = first.popchar();
			}
			else if(terminate == '/'){
				t = result.popdata()/first.popdata();
				terminate = first.popchar();
			}
			else{
				t = first.popdata();
				current = terminate;
				sign.push(current);
				terminate = first.popchar();
				char c2='+';
				// System.out.println("start");
				// sign.print();
				while(c2 != 'n' && terminate != '*' && terminate != '/'){
					c2 = sign.popchar();
					result.push(t);
					if(terminate != '*' && terminate != '/' && c2 == '+'){
					t = result.popdata() + result.popdata();
					}
					if(terminate != '*' && terminate != '/' && c2 == '-'){
						int firstdata = result.popdata();
						int seconddata = result.popdata();
						t = seconddata - firstdata;
					}	
				}
				
			}
		}
		result.push(t);
		System.out.println(result.popdata());
	}

}