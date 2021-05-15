import java.io.*;
import java.util.*;

class Main{
  

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	    Stack<String> pre = new Stack<>();
	    Stack<String> post = new Stack<>();
	    Stack<Character> op = new Stack<>();
	    for(int i = 0; i < exp.length(); i++){
	    	char ch = exp.charAt(i);
	    	if(ch == '('){
	    		op.push(ch);
	    	}else if(Character.isLetterOrDigit(ch)){
	    		pre.push(""+ch);
	    		post.push(""+ch);
	    	}else if(ch == ')'){
	    		while(op.peek() != '('){
	    			eval(pre, post, op);
	    		}
	    		op.pop();
	    	}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
	    		while( !op.empty() && op.peek() != '(' && precedence(ch) <= precedence(op.peek()) ){
	    			eval(pre, post, op);
	    		}
	    		op.push(ch);
	    	}
	    }
	    while( !op.empty()){
	    	eval(pre, post, op);
	    }
	    System.out.println(post.pop());
	    System.out.println(pre.pop());
	 }
	 
	 public static void eval(Stack<String> pre, Stack<String> post, Stack<Character> op){
	 	String val1,val2;
	 	// for prefix:
	 	val2 = pre.pop();
	 	val1 = pre.pop();
	 	pre.push(op.peek() + val1 + val2);
	 	
	 	// for post:
	 	val2 = post.pop();
	 	val1 = post.pop();
	 	post.push(val1 + val2 + op.pop());
	 }
	 
	 public static int precedence(char op){
	 	if(op == '+' || op == '-'){
	 		return 1;
	 	}else if(op == '*' || op == '/'){
	 		return 2;
	 	}
	 	return -1;
	 }
	 
}
