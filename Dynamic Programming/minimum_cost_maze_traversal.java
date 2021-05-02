import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
        int i,j,n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int a[][] = new int[n][m];
        for(i = 0; i < n; i++){
        	for(j = 0; j < m; j++){
        		a[i][j] = sc.nextInt();
        	}
        }
        int dp[][] = new int[n][m];
        for(i = n-1; i >= 0; i--){
        	for(j = m-1; j >= 0; j--){
	        	int cost = Integer.MAX_VALUE;
        		if(i < n-1 ){
        			cost = Math.min(cost,dp[i+1][j]);
        		}
        		if(j < m-1){
        			cost = Math.min(cost,dp[i][j+1]);
        		}
        		if(cost == Integer.MAX_VALUE){
        			cost = 0;
        		}
        		dp[i][j] = a[i][j] + cost;
        	}
        }
        System.out.println(dp[0][0]);
    }
 
}
