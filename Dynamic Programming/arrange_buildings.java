import java.io.*;
import java.util.*;
 
class Main{
 
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    long eachSide = cbs(n);
	    System.out.println(eachSide*eachSide);
	}
 
	// Number of binary strings with no consecutive zeros
	public static long cbs(int n){
		if(n <= 0){
			return 0;
		}
		long temp;
		long tz = 1; // Trailing zeros
		long to = 1; // Trailing ones
		for(int i = 2; i <= n; i++){
			temp = tz;
			tz = to;
			to = temp + to;
		}
		return tz + to;
	}
 
}
