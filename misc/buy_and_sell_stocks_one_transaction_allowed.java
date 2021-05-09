import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int i,min,ans,n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i = 0; i < n; i++){
        	arr[i] = sc.nextInt();
        }
        min = arr[0];
        ans = 0;
        for(i = 1; i < n; i++){
        	if(arr[i]-min > ans){
        		ans = arr[i]-min;
        	}
        	if(arr[i] < min){
        		min = arr[i];
        	}
        }
        System.out.println(ans);
    }

}
