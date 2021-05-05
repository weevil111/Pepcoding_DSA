import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tiling(n));
    }
    
    // public static int tiling(int n){
    // 	if(n <= 1){
    // 		return n;
    // 	}
    // 	int straight = 1, sideways = 1;// for n = 2
    // 	int prevStraight = 1, prevSideways = 0; // for n = 1
    // 	for(int i = 3; i <= n; i++){
    // 		int newStraight = straight+sideways;
    // 		int newSideways = prevStraight+prevSideways;
    // 		prevStraight = straight;
    // 		prevSideways = sideways;
    // 		straight = newStraight;
    // 		sideways = newSideways;
    // 	}
    // 	return straight+sideways; // Observation: the answer is simply (n+1)th fibonacci number
    // }
    public static int tiling(int n){
    	if(n <= 1){
    		return n;
    	}
    	
    	int prev = 1; // For 1
    	int curr = 2; // For 2
    	for(int i = 3; i <= n; i++){
    		// curr -> if we put new tile vertically, prev -> if we put new tile horizontally
    		int temp = curr + prev;
    		prev = curr;
    		curr = temp;
    	}
    	return curr;
    }
}
