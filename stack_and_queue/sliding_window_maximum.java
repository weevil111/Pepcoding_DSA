import java.io.*;
import java.util.*;

class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int i,j;
    for(i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
	
	Stack<Integer> stk = new Stack<>();
	int nextGreater[] = new int[n];
	for(i = n-1; i >= 0; i--){
		while(!stk.empty() && arr[stk.peek()] <= arr[i] ){
			stk.pop();
		}
		if(stk.empty()){
			nextGreater[i] = n+1;
		}else{
			nextGreater[i] = stk.peek();
		}
		stk.push(i);
	}
	
	// The variable j is used to keep 'jumping' from one higher to its higher until the next higher is out of frame.
	// This higher will be highest in the current frame
	for(i = 0, j = 0; i <= n - k; i++){
		
		// int j = i;
		// we are updating j only when required. Maybe the current place of j is answer for the current iteration. It is just a minor optimization
		
		if(j < i){
			j = i;
		}
		while(nextGreater[j] < i+k){
			j = nextGreater[j];
		}
		System.out.println(arr[j]);
	}
 }
}
