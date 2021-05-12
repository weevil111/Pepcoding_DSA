import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        int arr[] = new int[n];
        for( i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        
        int minimumPrice = arr[0]; // minimum price till now
        int dpLeft[] = new int[n]; // contains maximum profit till ith day
        
        for(i = 1; i < n; i++){
        	int maxProfitIfSoldToday;
        	if(arr[i] < minimumPrice){
        		minimumPrice = arr[i];
        	}
        	maxProfitIfSoldToday = arr[i] - minimumPrice;
        	if(maxProfitIfSoldToday > dpLeft[i-1]){
        		dpLeft[i] = maxProfitIfSoldToday;
        	}else{
        		dpLeft[i] = dpLeft[i-1];
        	}
        }
        
        int maxPrice = arr[n-1];
        int dpRight[] = new int[n];
        
        for( i = arr.length -2; i >= 0; i--){
        	int maximumProfitIfBoughtToday;
        	if(maxPrice < arr[i]){
        		maxPrice = arr[i];
        	}
        	maximumProfitIfBoughtToday = maxPrice - arr[i];
        	if(maximumProfitIfBoughtToday > dpRight[i+1]){
				dpRight[i] = maximumProfitIfBoughtToday;
        	}else{
        		dpRight[i] = dpRight[i+1];
        	}
        }
        
        int ans = 0;
        for(i = 0; i < n; i++){
        	if(dpLeft[i]+dpRight[i] > ans){
        		ans = dpLeft[i]+dpRight[i];
        	}
        }
        
        System.out.println(ans);
    }
	
}

// 19
// 30
// 40
// 43
// 50
// 45
// 20
// 26
// 40
// 80
// 50
// 30
// 15
// 10
// 20
// 40
// 45
// 71
// 50
// 55
