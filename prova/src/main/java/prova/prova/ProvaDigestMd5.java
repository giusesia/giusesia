package prova.prova;

import java.security.MessageDigest;
import java.util.Scanner;


public class ProvaDigestMd5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        MessageDigest md;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        try{

            md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest){
                System.out.printf("%02x", b);
            }
//            System.out.println("\n");
//        	md = MessageDigest.getInstance("SHA-256");
//        	md.update(s.getBytes());
//        	byte[] digest2 = md.digest();
//        	for (byte b : digest2) {
//				System.out.printf("%02x", b);
//			}
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}