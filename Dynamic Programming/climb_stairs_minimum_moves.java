import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        int []arr = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        Integer []dp = new Integer[n+1];
        dp[n] = 0;
 
        for(i = n-1; i >= 0; i-- ){
        	int min = Integer.MAX_VALUE;
        	for(j = 1; j <= arr[i] && i+j<=n; j++){
        		if(dp[i+j] != null && dp[i+j] < min){
        			min = dp[i+j];
        		}
        	}
        	if(min != Integer.MAX_VALUE){
        		dp[i] = min+1;
        	}
        }
 
        System.out.println(dp[0]);
    }
 
}
