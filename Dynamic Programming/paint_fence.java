import java.util.*;
 
 class Main {
 
 	 public static void main(String[] args) {
         // TODO Auto-generated method stub
         Scanner scn= new Scanner(System.in);
         int a=scn.nextInt();
         int b=scn.nextInt();
 	 	 System.out.println(CountWays(a,b));
 	 }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 integers
 	 // It should return the required output
 
 	 public static int CountWays(int n, int k) {
 	 	 //Write your code here
 	 	 int lastTwoSame, lastTwoDiff,temp;
 	 	 lastTwoSame = 0;
 	 	 lastTwoDiff = k;
 	 	 for(int i = 2; i <= n; i++){
 	 	 	temp = lastTwoDiff;
 	 	 	lastTwoDiff = (lastTwoSame + lastTwoDiff)*(k-1);
 	 	 	lastTwoSame = temp;
 	 	 }
 	 	 return lastTwoSame + lastTwoDiff;
 	 }
 }
