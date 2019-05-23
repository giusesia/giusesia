package prova.prova;

import java.util.Scanner;

public class ProvaParolaPalindroma {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next().toLowerCase();
        String reverse = new StringBuffer(A).reverse().toString();
        sc.close();
        
    	if(A.matches(reverse)) {
    		System.out.println("Yes");
    	}
    	else {
    		System.out.println("No");

         }
        
    }
   
}
