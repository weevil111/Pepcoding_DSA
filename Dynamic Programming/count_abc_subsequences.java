import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	String input = sc.next();
    	int a=0,ab=0,abc=0,i;
    	for(i = 0; i < input.length(); i++){
    		char ch = input.charAt(i);
    		switch(ch){
    			case 'a':
    				a = a*2 +1; 
    				break;
    			case 'b':
    				ab = ab*2 + a;
    				break;
    			case 'c':
    				abc = abc*2 + ab;
    			default:
    				break;
    		}
    	}
    	System.out.println(abc);
    }
}
