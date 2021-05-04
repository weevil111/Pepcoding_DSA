import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int n,i, inc=0, exc=0, temp;
    	n = sc.nextInt();
    	int arr[] = new int[n];
    	for(i = 0; i < n; i++){
    		arr[i] = sc.nextInt();
    		temp = arr[i]+exc;
    		exc = Math.max(inc,exc);
    		inc = temp;
    	}
    	System.out.println(Math.max(inc,exc));
    }
}
