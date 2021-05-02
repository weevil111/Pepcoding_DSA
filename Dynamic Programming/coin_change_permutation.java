import java.io.*;
import java.util.*;
 
class Main {
 
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n,i,amt,j,den;
		n = sc.nextInt();
		int arr[] = new int[n];
		for(i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		amt = sc.nextInt();
		int dp[] = new int[amt+1];
		dp[0] = 1;
		for(i = 1; i <= amt; i++){
			for(j = 0; j < n; j++){
				den = arr[j];
				if(den <= i){
					dp[i] += dp[i-den];
				}
			}
		}
		System.out.println(dp[amt]);
    }
}
