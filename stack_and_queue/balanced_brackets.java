import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(isBalanced(str));
    }
    public static boolean isBalanced(String str){
    	Stack<Character> stk = new Stack<>();
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == '[' || ch == '{' || ch == '('){
				stk.push(ch);
			}else{
				switch(ch){
					case ']':
						if(stk.empty() || stk.pop() != '['){
							return false;
						}
						break;
					case '}':
						if(stk.empty() || stk.pop() != '{'){
							return false;
						}
						break;
					case ')':
						if(stk.empty() || stk.pop() != '('){
							return false;
						}
						break;
				}
			}
		}
		if(stk.empty()){
			return true;
		}
		return false;
    }

}
