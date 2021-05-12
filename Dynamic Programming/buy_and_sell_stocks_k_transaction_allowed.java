import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,t,i,j;
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        t = sc.nextInt();
        int dp[][] = new int[t+1][n];
        
        // for(i = 1; i <= t; i++){
        // 	for(j = 1; j < n; j++){
        // 		int max = dp[i][j-1]; // "t" transactions are exhausted by yesterday
        // 		for(int k = 0; k < j; k++){
        // 			int profit = dp[i-1][k] + (arr[j] - arr[k]);// Third transaction was squared off today
        // 			if(profit > max){
        // 				max = profit;
        // 			}
        // 		}
        // 		dp[i][j] = max;
        // 	}
        // }
        
        // optimized version
        
        for(i = 1; i <= t; i++){
        	// It can be negative thus it is initialized with -infinity
    		int maxPrev = Integer.MIN_VALUE; // This will store max in previous row till current j (without the current price which keeps changing with j)
    		// We rearrange this: dp[i-1][k] + (arr[j] - arr[k]) to (dp[i-1][k] - arr[k]) + arr[j] 
    		// arr[j] changes for each "j" but dp[i-1][k] = arr[k] remains constant. This is what maxPrev stores.
    		// When comparing for each "j", we use maxPrev and add arr[j] 
        	for(j = 1; j < n; j++){
        		int max = dp[i][j-1];
        		if(dp[i-1][j-1] - arr[j-1] > maxPrev){
        			maxPrev = dp[i-1][j-1] - arr[j-1]; // updating maxPrev with yesterday's t-1 transaction (if it is greater than current maxPrev)
        		}
        		if(maxPrev + arr[j] > max){
        			max = maxPrev + arr[j];
        		}
        		dp[i][j] = max;
        	}
        }
        System.out.println(dp[t][n-1]);
    }

}
