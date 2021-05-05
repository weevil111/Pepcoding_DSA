import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	System.out.println(tilingM(n,m));
    }
    
    public static long tilingM(int n, int m){
    	if(m == 1){
    		return 1;
    	}
    	long dp[] = new long[n+1];
    	for(int i = 0; i <= n; i++){ // dp[0] = 1 is used when i = m
    		if(i< m){
    			dp[i] = 1;
    		}else{
    			dp[i] = dp[i-m] + dp[i-1];
    		}
    	}
    	return dp[n];
    }
}
