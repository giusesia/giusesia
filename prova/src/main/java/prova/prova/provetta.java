package prova.prova;

import java.util.Scanner;

public class provetta {



//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//    	System.out.println("Dimmi valore:" );
//        int N = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        
//        for(int i=1; i<=10; i++){
//        	
//
//            System.out.println( N +" x "+ i +" = "+ N*i);
//
//
//        }
//
//        scanner.close();
//    }

//	public static void main(String []argh){
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        int a,b,n;
//        for(int i=0;i<t;i++){
//            a = in.nextInt();
//            b = in.nextInt();
//            n = in.nextInt();
//            faiLoop(a,b,n);
//        }
//        in.close();
//    }
//
//    static void faiLoop(int a, int b, int n){
//        int somma = a;
//        for (int i =0; i<n; i++){
//            somma += b*(1<<i);
//            System.out.print(somma + " ");
//        }
//        System.out.println(" ");
//    }
//	public static void main(String[] args) {
//		boolean flag = true; int B,H;
//
//
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Inserisci Base ");
//		B = scan.nextInt();
//		scan.nextLine();
//		System.out.println("Inserisci Altezza");
//		H = scan.nextInt();
//		scan.close();
//		if((B<=0 && H<=0)||(B>=0 && H>=0)){
//		    flag = true;
//
//		}else if((B<=0 && H>=0)||(B>=0 && H<=0)){
//		    flag=false;
//		    System.out.println("java.lang.Exception: Breadth and height must be positive");
//		}
//		if(flag){
//			int area=B*H;
//			System.out.print(area);
//		}
//
//    }

	    public static String getSmallestAndLargest(String s, int k) {
	        String smallest = "";
	        String largest = "";
	        
	        // Complete the function
	        // 'smallest' must be the lexicographically smallest substring of length 'k'
	        // 'largest' must be the lexicographically largest substring of length 'k'
	        
	        smallest = s.substring(0,k);
	        largest = s.substring(0,k);
	        for (int i = 0; i <= s.length() - k; i++) {
	            String sub = s.substring(i,  i + k);
	            if (sub.compareTo(smallest) < 0) {
	                smallest = sub;
	            }
	            if (sub.compareTo(largest) > 0) {
	                largest = sub;
	            }
	        }
//	        return "Minore :" +smallest + "\n Maggiore :" + largest;
	        return smallest + "\n" + largest;
	    }


	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Sequenza di valori: ");
	        String s = scan.next();
	        System.out.println("Lunghezza della sequenza  di cifre fra cui vuoi determinare: ");
	        int k = scan.nextInt();

	        scan.close();
	      
	        System.out.println(getSmallestAndLargest(s, k));
	    }

}
