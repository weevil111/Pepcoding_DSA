import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n,cap,i,j;
    	n = sc.nextInt();
    	int val[] = new int[n];
    	int wt[] = new int[n];
    	for(i = 0; i < n; i++){
    		val[i] = sc.nextInt();
    	}
    	for(i = 0; i < n; i++){
    		wt[i] = sc.nextInt();
    	}
    	cap = sc.nextInt();
    	int dp[] = new int[cap+1];
    	for(i = 1; i <= cap; i++){
    		for(j = 0; j < n; j++){
    			if(wt[j] <= i){
	    			dp[i] = Math.max(dp[i-wt[j]]+val[j],dp[i]);
    			}
    		}
    	}
    	System.out.println(dp[cap]);
    }
}
