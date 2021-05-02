import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
    	int i,j,n,tar;
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	int arr[] = new int[n];
    	for(i = 0; i < n; i++){
    		arr[i] = sc.nextInt();
    	}
    	tar = sc.nextInt();
    	System.out.println(targetSumSubset(arr,tar));
    }
 
    public static boolean targetSumSubset(int []arr, int tar){
    	boolean [][] dp = new boolean[arr.length+1][tar+1];
    	int i,j;
    	dp[0][0] = true;
    	for(i = 1; i <= arr.length; i++){
    		int element = arr[i-1];
    		for(j = 0; j <= tar; j++){
    			if(dp[i-1][j]){ // If the current target "j" can be made without element
    				dp[i][j] = true;
    				continue;
    			}
    			if(element <= j && dp[i-1][j-element]){ // If the current target can be made while including the current element
    				dp[i][j] = true;
    			}
    		}
    	}
    	return dp[arr.length][tar];
    }
}
