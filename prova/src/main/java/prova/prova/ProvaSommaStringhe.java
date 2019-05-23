package prova.prova;

import java.util.Scanner;

public class ProvaSommaStringhe {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        sc.close();
        int lenghtSomma = A.length()+B.length();
        
        System.out.println(lenghtSomma);
       
        String inizialeA = A.substring(0, 1);
        String finaleA = A.substring(1, A.length());
        String A1 = inizialeA.toUpperCase() + finaleA.toLowerCase();
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        String inizialeB = B.substring(0, 1);
        String finaleB = B.substring(1, B.length());
        String B1 = inizialeB.toUpperCase() + finaleB.toLowerCase();
        System.out.println(A1+" "+B1);
        
    }
}
