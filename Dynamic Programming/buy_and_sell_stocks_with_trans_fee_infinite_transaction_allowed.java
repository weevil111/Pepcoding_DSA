import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,fee,i,buyDate = 0, sellDate = 0, profit = 0, temp;
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        fee = sc.nextInt();
        // for( i = 1; i < n; i++){
        // 	if( arr[i] < arr[i-1]){
        // 		if(sellDate == buyDate){
        // 			sellDate = i;
        // 			buyDate = i;
        // 		}else if(arr[sellDate] - arr[i] > fee){
        // 			temp = arr[sellDate] - arr[buyDate] - fee;
        // 			if(temp > 0){
	       // 			profit += temp;
        // 			}
        // 			sellDate = i;
        // 			buyDate = i;
        // 		}
        // 	}else{
        // 		sellDate = i;
        // 	}
        // }
        // temp = arr[sellDate] - arr[buyDate] - fee;
        // if(temp > 0){
        // 	profit += temp;
        // }
        // System.out.println(profit);
        System.out.println(usingDP(arr,n,fee));
    }
    public static int usingDP(int arr[], int n, int fee){
    	// wallet contains how much minimum can we owe/have after buying current stock
    	int wallet=-1*arr[0], maxProfit=0,i,currProfit;
    	for(i = 1; i < n; i++){
    		currProfit = wallet + arr[i] - fee; // wallet is added because it contains stock buy price in negative form
    		// The condition below checks whether buying current stock will give us profit ? Note that fees is already 
    		// present in maxProfit. To understand this, consider 0 fees.
    		if(maxProfit-arr[i] > wallet){
    			// Here we are reducing the all the future stock prices by maxProfit
    			// now if we make profit, the current profit is automatically included thus acheiving cumulative profit
    			// For example if we made profit of 30 rs then 60 rs stock will be considered 50rs.
    			// That way if we sell at 100rs, then 70 rs profit (30rs from previous + 40rs from 100-60) whereing 30rs was previous profit that we hid in
    			// "buy price of stock" by reducing it by amount equivalent to previous profit.
    			wallet = maxProfit-arr[i]; 
    		}
    		if(currProfit > maxProfit){
    			maxProfit = currProfit;
    		}
    		// System.out.println(wallet+" "+maxProfit);
    	}
    	return maxProfit;
    	// How wallet and maxProfit changes for the given example
		// -10 2
		// -10 4
		// -10 7
		// -9 7
		// -9 7
		// -9 10
		// -9 10
		// -9 10
		// -9 10
		// -9 11
		// -9 13
    }

}
