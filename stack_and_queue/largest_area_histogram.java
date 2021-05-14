import java.io.*;
import java.util.*;

class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    
    System.out.println(largestArea( leftEdge(arr), rightEdge(arr), arr ));
    
 }
 
 public static int[] leftEdge(int [] arr){
 	Stack<Integer> stk = new Stack<>();
 	int i,n = arr.length;
 	int [] ans = new int[n];
 	for(i = 0; i < n; i++){
 		while(!stk.empty() && arr[stk.peek()] >= arr[i]){
 			stk.pop();
 		}
 		if(stk.empty()){
 			ans[i] = 0;
 		}else{
 			ans[i] = stk.peek()+1;
 		}
 		stk.push(i);
 	}
 	return ans;
 }
 
 public static int[] rightEdge(int [] arr){
 	Stack<Integer> stk = new Stack<>();
 	int i,n = arr.length;
 	int [] ans = new int[n];
 	for(i = n-1; i >= 0; i--){
 		while(!stk.empty() && arr[stk.peek()] >= arr[i]){
 			stk.pop();
 		}
 		if(stk.empty()){
 			ans[i] = n-1;
 		}else{
 			ans[i] = stk.peek() - 1;
 		}
 		stk.push(i);
 	}
 	return ans;
 }
 
 public static int largestArea(int [] left, int[] right, int [] arr){
 	int max = 0, currArea;
 	for(int i = 0; i < arr.length; i++){
 		currArea = arr[i] * (right[i] - left[i] + 1);
 		if(currArea > max){
 			max = currArea;
 		}
 	}
 	return max;
 }
 
}
