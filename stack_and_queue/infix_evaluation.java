import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	    Stack<Integer> operands = new Stack<>();
	    Stack<Character> operators = new Stack<>();
	    for(int i = 0; i < exp.length(); i++){
	    	char ch = exp.charAt(i);
	    	if(Character.isDigit(ch)){
	    		operands.push(ch-'0');
	    	}else if(ch == '('){
	    		operators.push(ch);
	    	}else if (ch == ')'){
	    		while( operators.peek() != '(' ){
	    			eval(operands, operators);
	    		}
	    		operators.pop();
	    	}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
	    		while(!operators.empty() && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek()) ){
	    			eval(operands, operators);
	    		}
	    		operators.push(ch);
	    	}
	    }
	    while(!operators.empty()){
	    	eval(operands, operators);
	    }
	    System.out.println(operands.pop());
	}
	
	public static void eval(Stack<Integer> operands, Stack<Character> operators){
		int v2 = operands.pop();
		int v1 = operands.pop();
		switch(operators.pop()){
			case '+':
				operands.push(v1 + v2);
				break;
			case '-':
				operands.push(v1 - v2);
				break;
			case '*':
				operands.push(v1 * v2);
				break;
			case '/':
				operands.push(v1 / v2);
				break;
			default:
				return;
		}
	}
	
	public static int precedence(char operator){
		if(operator == '+' || operator == '-'){
			return 1;
		}else if(operator == '*' || operator == '/'){
			return 2;
		}
		return -1;
	}
	
}
