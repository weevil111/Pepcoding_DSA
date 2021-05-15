import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        int i,j;
        Stack<Integer> stk = new Stack<>();
        for(i = 0; i < arr.length; i++){
        	stk.push(i);
        }
        
        while(stk.size() >= 2){
        	i = stk.pop();
        	j = stk.pop();
        	if(arr[i][j] == 1){
        		// if i knows j -> i is not celebrity
        		stk.push(j);
        	}else{
        		// if i does not knows j -> j is not celebrity
        		stk.push(i);
        	}
        }
        
        int potentialCelebrity = stk.pop();
        for(i = 0; i < arr.length; i++){
        	if(i != potentialCelebrity && (arr[potentialCelebrity][i] == 1 || arr[i][potentialCelebrity] == 0) ){ // i = j (diagonal) is always 0 so we don't check it
        		System.out.println("none");
        		return;
        	}
        }
        System.out.println(potentialCelebrity);
    }

}
