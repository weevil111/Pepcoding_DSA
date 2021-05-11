import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,profit = 0, ans=0;
		int arr[] = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        // boolean transact = true;
        // for(i = 1; i < n; i++){
        // 	if(arr[i] < arr[i-1]){
        // 		if(transact){
	       // 		ans += profit;
	       // 		transact = false;
	       // 		profit = 0;
        // 		}
        // 	}else{
        // 		profit += arr[i] - arr[i-1];
        // 		transact = true;
        // 	}
        // }
        // if(profit > 0){
        // 	ans += profit;
        // }
        // System.out.println(ans);
        
        // Alternatively
        int bd = 0, sd = 0; // buy date and sell date
        for( i = 1; i < n; i++){
        	if(arr[i] >= arr[i-1]){
        		sd++;
        	}else{
        		profit += arr[sd] - arr[bd];
        		bd=sd=i;
        	}
        }
        profit += arr[sd] - arr[bd]; // if there was no dip in the last
        System.out.println(profit);
    }

}
