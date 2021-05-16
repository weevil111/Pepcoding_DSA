import java.io.*;
import java.util.*;

class Main{
  

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	
	    // code
	    Stack<Integer> eval = new Stack<>();
	    Stack<String> infix = new Stack<>();
	    Stack<String> post = new Stack<>();
	    
	    for(int i = exp.length() - 1; i >=0; i--){
	    	char ch = exp.charAt(i);
	    	if(Character.isDigit(ch)){
	    		eval.push(ch - '0');
	    		infix.push("" + ch);
	    		post.push("" + ch);
	    	}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
	    		update(eval, infix, post, ch);
	    	}
	    }
	    System.out.println(eval.pop());
	    System.out.println(infix.pop());
	    System.out.println(post.pop());
	}
	
	public static void update( Stack<Integer> eval, Stack<String> infix,Stack<String> post, char op){
		// Since we are traversing backwards, the value 1 will be at the top (unlike previous questions)
		int val1 = eval.pop();
		int val2 = eval.pop();
		switch(op){
			case '+':
				eval.push(val1 + val2);
				break;
			
			case '-':
				eval.push(val1 - val2);
				break;
			
			case '*':
				eval.push(val1 * val2);
				break;
			
			case '/':
				eval.push(val1 / val2);
				break;
		}
		
		String infixVal1 = infix.pop();
		String infixVal2 = infix.pop();
		infix.push( "(" + infixVal1 + op + infixVal2 + ")" );
		
		String postVal1 = post.pop();
		String postVal2 = post.pop();
		post.push(postVal1 + postVal2 + op);
	}
}
