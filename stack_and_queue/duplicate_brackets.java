import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	boolean duplicatePresent = false;
    	Stack<Character> stk = new Stack<>();
    	for(int i = 0; i < str.length(); i++){
    		char ch = str.charAt(i);
    		switch(ch){
    			case ' ':
    				break;
    			case ')':
    				if(stk.peek() == '('){
    					duplicatePresent = true;
    				}else{
    					while(stk.pop() != '(');
    				}
    				break;
    			default:
    				stk.push(ch);
    		}
    		if(duplicatePresent){
    			break;
    		}
    	}
    	System.out.println(duplicatePresent);
    }
 
}

