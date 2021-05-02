import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,m,i,j;
        n = sc.nextInt();
        m = sc.nextInt();
        int mine[][] = new int[n][m];
        for(i = 0; i < n; i++){
        	for(j = 0; j < m; j++){
        		mine[i][j] = sc.nextInt();
        	}
        } 
        int dp[] = new int[n];
        int temp[] = new int[n];
        for(i = 0; i < n; i++){
        	temp[i] = mine[i][m-1];
        	// System.out.print(dp[i]+" ");
        }
        // System.out.println();
        for(j = m-2; j >= 0; j--){
        	for(i = 0; i < n; i++){
        		int maxGold = -1;
    			if(i != 0 && temp[i-1] > maxGold){
    				maxGold = temp[i-1];
    			}
    			if(maxGold < temp[i]){
    				maxGold = temp[i];
    			}
    			if(i != n-1 && temp[i+1] > maxGold){
    				maxGold = temp[i+1];
    			}
    			dp[i] = mine[i][j] + maxGold;
        	}
        	for(i = 0; i < n; i ++){
        		temp[i] = dp[i];
        	}
        	// for(int k = 0; k < n; k++){
        	// 	System.out.print(dp[k]+" "+(k==n-1?"\n":""));
        	// }
        }
        int max = -1;
        for(i = 0; i < n; i++){
        	if(dp[i]>max){
        		max = dp[i];
        	}
        }
        System.out.println(max);
    }
 
}
