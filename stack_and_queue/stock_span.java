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

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   Stack<Integer> stk = new Stack<>();
   int span[] = new int[arr.length];
   for(int i = 0; i < arr.length; i++){
      while(!stk.empty() && arr[stk.peek()] <= arr[i]){
      	stk.pop();
      }
      if(stk.empty()){
      	span[i] = i+1;
      }else{
      	span[i] = i-stk.peek();
      }
      stk.push(i);
   }
   return span;
 }

}
