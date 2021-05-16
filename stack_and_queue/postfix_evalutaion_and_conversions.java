import java.io.*;
import java.util.*;

class Main{
  

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	
	    // code
	    Stack<Integer> eval = new Stack<>();
	    Stack<String> infix = new Stack<>();
	    Stack<String> pre = new Stack<>();
	    
	    for(int i = 0; i < exp.length(); i++){
	    	char ch = exp.charAt(i);
	    	if(Character.isDigit(ch)){
	    		eval.push(ch-'0');
	    		infix.push("" + ch);
	    		pre.push(""+ch);
	    	}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
	    		update(eval, pre, infix, ch);
	    	}
	    }
	    System.out.println(eval.pop());
	    System.out.println(infix.pop());
	    System.out.println(pre.pop());
	}
	
	public static void update(Stack<Integer> eval, Stack<String> pre, Stack<String> infix, char op){
		int val2 = eval.pop();
		int val1 = eval.pop();
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
		String operand2 = pre.pop();
		String operand1 = pre.pop();
		pre.push(op + operand1 + operand2);
		
		String oper2 = infix.pop();
		String oper1 = infix.pop();
		infix.push("(" + oper1 + op + oper2 + ")" );
	}
}
