import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	int n,k,i,j;
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	k = sc.nextInt();
    	int arr[][] = new int[n][k];
    	for(i = 0; i < n; i++){
    		for(j = 0; j < k; j++){
    			arr[i][j] = sc.nextInt();
    		}
    	}
    	long min=0,smin=0,new_min,new_smin;
    	// long dp[][] = new long[n][k];
    	// for(i = 0; i < n; i++){
    	// 	new_min = Long.MAX_VALUE;
    	// 	new_smin = Long.MAX_VALUE;
    	// 	for(j = 0; j < k; j++){
    	// 		if(i == 0){
    	// 			dp[i][j] = arr[i][j];
    	// 		}else{
    	// 			if(dp[i-1][j] == min){
    	// 				dp[i][j] = arr[i][j] + smin;
    	// 			}else{
    	// 				dp[i][j] = arr[i][j] + min;
    	// 			}
    	// 		}
    			
    			
    	// 		if(dp[i][j] <= new_min){
    	// 			new_smin = new_min;
    	// 			new_min = dp[i][j];
    	// 		}else if(dp[i][j] < new_smin){
    	// 			new_smin = dp[i][j];
    	// 		}
    	// 	}
    	// 	min = new_min;
    	// 	smin = new_smin;
    	// }
    	
    	// alternatively we can do using one dimensional dp
    	
    	long dp[] = new long[k];
    	for(i = 0; i < n; i++){
    		new_min = Long.MAX_VALUE;
    		new_smin = Long.MAX_VALUE;
    		for(j = 0; j < k; j++){
    			if(i == 0){
    				dp[j] = arr[i][j];
    			}else{
    				if(dp[j] == min){
    					dp[j] = arr[i][j] + smin;
    				}else{
    					dp[j] = arr[i][j] + min;
    				}
    			}
    			
    			if(dp[j] <= new_min){
    				new_smin = new_min;
    				new_min = dp[j];
    			}else if(dp[j] < new_smin){
    				new_smin = dp[j];
    			}
    		}
    		min = new_min;
    		smin = new_smin;
    	}
    	
    	System.out.println(min);
    }
}
