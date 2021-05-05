import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fp(n));
    }

	public static int fp(int n){
		if(n == 1){
			return n;
		}
		int prev = 1; // For n = 1;
		int curr = 2; // For n = 2;
		// The i th friend will either remain single ( fp(n-1)*1 )
		// or will pair with any of the n-1 others. In second case, n-2 friends will be left
		// Thus for second case, fp(n-2)*(n-1);
		for(int i = 3; i <= n; i++){
			int next = curr + prev*(i-1);
			prev = curr;
			curr = next;
		}
		return curr;
	}
}
