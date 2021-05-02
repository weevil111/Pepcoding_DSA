import java.io.*;
import java.util.*;
 
class Main{
 
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    System.out.println(cbs(n));
	}
	// using dp array:
 
	// public static int cbs(int n){
	// 	int dp0[] = new int[n+1];
	// 	int dp1[] = new int[n+1];
	// 	dp0[1] = 1;
	// 	dp1[1] = 1;
	// 	for(int i = 2; i <= n; i++){
	// 		dp0[i] = dp1[i-1];
	// 		dp1[i] = dp0[i-1] + dp1[i-1];
	// 	}
	// 	return dp0[n]+dp1[n];
	// }
 
	// Since only previos values are required, thus making array is unnecessary
	public static int cbs(int n){
		if(n <= 0){
			return 0;
		}
		int temp;
		int tz = 1; // Trailing zeros
		int to = 1; // Trailing ones
		for(int i = 2; i <= n; i++){
			temp = tz;
			tz = to;
			to = temp + to;
		}
		return tz + to;
	}
 
}
