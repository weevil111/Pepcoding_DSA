import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
    	int n,i,j,amt;
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	int d[] = new int[n];
    	for(i = 0; i < n; i++){
    		d[i] = sc.nextInt();
    	}
    	amt = sc.nextInt();
    	// can be done using single dimensional dp.
    	// Update the same array for each coin one after other.
    	// This ensures that coins will always be used in the same order. 2->5->7 etc not 5->2
    	int dp[][] = new int[n+1][amt+1];
    	dp[0][0] = 1;
    	for(i = 1; i <= n; i++){
    		for(j = 0; j <= amt; j++){
    			dp[i][j] += dp[i-1][j];
    			if(d[i-1] <= j){
    				dp[i][j] += dp[i][ j - d[i-1] ];
    			}
    			// System.out.print(dp[i][j]+" ");
    		}
    		// System.out.println();
    	}
    	System.out.println(dp[n][amt]);
    }
}
