import java.util.*;
  
class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[][] costs= new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                costs[i][j]=scn.nextInt();
            }
        }
         System.out.println(minCost(costs));
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input 2D array
    // It should return the required output

    public static int minCost(int[][] costs) {
        //Write your code here
        int red = 0, blue = 0, green = 0;
        int i,j,n = costs.length;
        for(i = 0; i < n; i++){
          int nred, nblue, ngreen;
      nred = Math.min(blue,green) + costs[i][0];
      nblue = Math.min(red,green) + costs[i][1];
      ngreen = Math.min(red,blue) + costs[i][2];

      red = nred;
      blue = nblue;
      green = ngreen;
        }
        return Math.min(red,Math.min(blue,green));
    }
}
