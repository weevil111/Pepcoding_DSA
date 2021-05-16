import java.io.*;
import java.util.*;

class Main{
  

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	
	    // code
	    solution(str);
	}
	// 
	public static void solution( String str) {
		Stack<Integer> stk = new Stack<>();
		int num = 1;
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch == 'd'){
				// stack is being used because we have to print in reverse for 'd' characters
				stk.push(num++);
			}else{
				stk.push(num++);
				while(!stk.empty()){
					System.out.print(stk.pop());
				}
			}
		}
		stk.push(num);
		while(!stk.empty()){
			System.out.print(stk.pop());
		}
	}
}
