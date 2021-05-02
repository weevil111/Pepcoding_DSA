import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	String num = sc.next();
    	System.out.println(countEncodings(num));
    }
    public static int countEncodings(String num){
    	
    	int digit,i;
    	char curr,prev;
    	int dp[] = new int[num.length()+1];
    	dp[0] = 1; // Used for special case when num length is 2
    	dp[1] = 1; // It is given in the question that first character won't be 0
    	
    	for( i = 2; i <= num.length(); i++){
    		curr = num.charAt(i-1);
    		prev = num.charAt(i-2);
    		if(curr=='0' && (prev != '1' || prev !='2')){
    			return 0;
    		}
    		if(curr != '0'){
    			dp[i] = dp[i-1];
    		}
    		if(prev == '1' || prev == '2'){
	    		dp[i] += dp[i-2];
    		}
    	}
    	return dp[num.length()];
    }
}
