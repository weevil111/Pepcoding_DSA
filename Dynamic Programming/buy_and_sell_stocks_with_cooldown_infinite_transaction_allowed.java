import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,i;
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        // int profitToday = 0, profitPrev=0, profitOld = 0, buyToday, buyPrev;
        // buyToday = buyPrev = -arr[0]; // We purchase stock on first day, hence negative balance in our wallet.
        // for(i = 1; i < n; i++){
        // 	int temp = buyPrev;
        // 	if(profitOld - arr[i] > buyPrev){
        // 		buyToday = profitOld - arr[i];
        // 		buyPrev = buyToday;
        // 	}else{
        // 		buyToday = buyPrev;
        // 	}
        // 	if(temp + arr[i] > profitPrev){
        // 		profitToday = temp + arr[i];
        // 		profitOld = profitPrev;
        // 		profitPrev = profitToday;
        // 	}else{
        // 		profitOld = profitPrev;
        // 		profitToday = profitPrev;
        // 	}
        // }
        
        // System.out.println(profitToday);
        
        // Cleaner way ( no change in logic)
        
        int oldBuy = -arr[0]; // maximum balance we can have if we have an unsold stock. We start with buying first stock (say price = 10), thus oldBuy = -10
        int oldSell = 0; // max profit till now
        int cooldownProfit = 0; // This stores the sell profit of 2 days back
        for( i = 1; i < n; i++){
        	int newBuy = oldBuy;
        	int newSell = oldSell;
        	
        	if( cooldownProfit - arr[i] > oldBuy){
        		newBuy = cooldownProfit - arr[i];
        	}
        	
        	if( oldBuy + arr[i] > oldSell){
        		newSell = oldBuy + arr[i];
        	}
        	
        	cooldownProfit = oldSell;
        	oldBuy = newBuy;
        	oldSell = newSell;
        }
        System.out.println(oldSell);
    }

}

