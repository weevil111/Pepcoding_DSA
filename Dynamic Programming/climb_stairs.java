import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
        // write your code here
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
        	dp[i] += dp[i+1];
        	if(i+2 <= n){
        		dp[i] += dp[i+2];
        	}
        	if(i+3 <= n){
        		dp[i] += dp[i+3];
        	}
        }
        System.out.println(dp[0]);
    }
 
}
