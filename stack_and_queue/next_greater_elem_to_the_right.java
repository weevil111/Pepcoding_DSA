import java.io.*;
import java.util.*;

class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   Stack<Integer> stk = new Stack<>();
   int n = arr.length;
   stk.push(arr[n-1]);
   int ans[] = new int[n];
   ans[n-1] = -1;
   for(int i = n-1; i >= 0; i--){
   	
   	// if(arr[i] < stk.peek()){
   	// 	ans[i] = stk.peek();
   	// }else{
   	// 	ans[i] = -1;
   	// 	while(!stk.empty() ){
   	// 		if(stk.peek() <= arr[i]){
	   //			stk.pop();
   	// 		}else{
   	// 			ans[i] = stk.peek();
   	// 			break;
   	// 		}
   	// 	}
   	// }
   	// stk.push(arr[i]);
   	
   	// rearranging and organising
   	
   	// Empty all the elements in stack smaller than arr[i] because arr[i] is greater element to the right of
   	// all the left side elements that are SMALLER THAN arr[i].
   	while(!stk.empty() && arr[i] >= stk.peek()){
   		stk.pop();
   	}
   	
   	if(stk.empty()){
   		ans[i] = -1;
   	}else{
   		ans[i] = stk.peek();
   	}
   	
   	stk.push(arr[i]);
   	
   }
   return ans;
   
   // complexity is linear because we are pushing each element only ONCE in the stack
   // Thus pop operation (the while loop) can only be performed at max "n" times
   // Hence the complexity will 2n
   
 }

}
