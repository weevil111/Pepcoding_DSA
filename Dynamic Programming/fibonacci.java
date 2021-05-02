import java.io.*;
import java.util.*;
 
class Main{
 
	public static void main(String[] args) throws Exception {
	    // write your code here
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int qb[] = new int[n+1];
	    int ans = fib(n,qb);
	    System.out.println(ans);
	}
	public static int fib(int n, int [] qb){
		if(n==0|| n==1){
			return n;
		}
		if(qb[n] != 0){
			return qb[n];
		}
		int ans = fib(n-1,qb) + fib(n-2,qb);
		qb[n] = ans;
		return ans;
	}
 
}
