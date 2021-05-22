import java.io.*;
import java.util.*;

class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      if(data.empty()){
      	min = val;
      	data.push(val);
      }else{
      	if(val >= min){
      		data.push(val);
      	}else{
      		// This case detects when we encountered a smaller value. We push an encrypted value, which is 
      		// sure to be less than the future min ( current val is going to be next min; so we ensure that the encrypted value is less than val)
      		// The value of val-min is negative (say a). So val + a < val which is what we want
      		// In pop, we will use the current min and top of stack to get bach the original val
      		data.push(val + val - min);
      		min = val;
      	}
      }
    }

    int pop() {
      if(data.empty()){
      	System.out.println("Stack underflow");
      	return -1;
      }else{
      	int val = data.pop();
      	if(val >= min){
      		return val; // No encryption was done here
      	}else{
      		int originalVal = min;
      		min = 2 * originalVal - val;
      		return originalVal;
      	}
      }
    }

    int top() {
      // write your code here
      if(data.empty()){
      	System.out.println("Stack underflow");
      	return -1;
      }else{
      	int val = data.peek();
      	if(val >= min){
      		return val; // No encryption was done here
      	}else{
      		return min;
      	}
      }
    }

    int min() {
      if(data.empty()){
      	System.out.println("Stack Underflow");
      	return -1;
      }
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
