import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n,cap,i,j;
    	n = sc.nextInt();
    	int val[] = new int[n];
    	int weight[] = new int[n];
    	for( i = 0; i < n; i++){
    		val[i] = sc.nextInt();
    	}
    	for( i = 0; i < n; i++){
    		weight[i] = sc.nextInt();
    	}
    	cap = sc.nextInt();
 
    	// Simple version without optmizing space complexity:
 
     	// int dp[][] = new int[n+1][cap+1];
    	// for(i = 1; i <= n; i++){
    	// 	for(j = 1; j <= cap; j++){
    	// 		dp[i][j] = dp[i-1][j];
    	// 		if(j >= weight[i-1]){
    	// 			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i-1]]+val[i-1] );
    	// 		}
 
    	// 	}
    	// }
    	// System.out.println(dp[n][cap]);
 
    	// linear space complexity:
 
    	int dp[] = new int[cap+1];
    	for(i = 0; i < n; i++){
    		for(j = cap; j >= weight[i]; j--){
    			dp[j] = Math.max(dp[j],dp[j-weight[i]] + val[i]);
    		}
    	}
    	System.out.println(dp[cap]);
    }
}
