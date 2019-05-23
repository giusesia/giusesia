package prova.prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

class Result {

	public static String findDay(int month, int day, int year) {

		String giorno = "";

		int temp = 0;

		Calendar calendario = Calendar.getInstance();
		calendario.set(year, month - 1, day);

		temp = calendario.get(Calendar.DAY_OF_WEEK);
		temp = temp - 1;
		int resto = temp % 7;
		switch (resto) {
		case 0:
			giorno = "DOMENICA";
			break;

		case 1:
			giorno = "LUNEDI";
			break;
		case 2:
			giorno = "MARTEDI";
			break;
		case 3:
			giorno = "MERCOLEDI";
			break;
		case 4:
			giorno = "GIOVEDI";
			break;
		case 5:
			giorno = "VENERDI";
			break;
		case 6:
			giorno = "SABATO";
			break;
		case 7:
			giorno = "DOMENICA";
			break;

		}

		return giorno;

	}
	
	public static String findMounth(int mounth) {

		String mese = "";

	
		switch (mounth) {
		case 0:
			mese = " ";
			break;
		case 1:
			mese = "GENNAIO";
			break;
		case 2:
			mese = "FEBBRAIO";
			break;
		case 3:
			mese = "MARZO";
			break;
		case 4:
			mese = "APRILE";
			break;
		case 5:
			mese = "MAGGIO";
			break;
		case 6:
			mese = "GIUGNO";
			break;
		case 7:
			mese = "LUGLIO";
			break;
		case 8:
			mese = "AGOSTO";
			break;
		case 9:
			mese = "SETTEMBRE";
			break;
		case 10:
			mese = "OTTOBRE";
			break;
		case 11:
			mese = "NOVEMBRE";
			break;
		case 12:
			mese = "DICEMBRE";
			break;

		}

		return mese;

	}

}

public class Solutions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println("Scrivi Data con formato DD MM YYYY");
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int day = Integer.parseInt(firstMultipleInput[0]);
        
        int month = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);
        System.out.println("Giorno : "+res+ "\nMese : "+Result.findMounth(month)+"\nAnno : "+year);

        bufferedReader.close();

    }
//	  public static void main(String[] args) {
//	        Scanner scanner = new Scanner(System.in);
//	        double payment = scanner.nextDouble();
//	        scanner.close();
//	        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
//	        String us = nf.format(payment);
//	        
//	        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
//	        String china = nf.format(payment);
//	        
//	        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
//	        String france = nf.format(payment);
//	        
//	        nf = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
//	        String india = nf.format(payment);
//	        System.out.println("US: " + us);
//	        System.out.println("India: " + india);
//	        System.out.println("China: " + china);
//	        System.out.println("France: " + france);
//
//	}
	
}
//public class Solutions {
//	static boolean isAnagram(String a, String b) {
//		// test for invalid input
//		if (a == null || b == null || a.equals("") || b.equals(""))
//			throw new IllegalArgumentException();
//
//// initial quick test for non-anagrams
//		if (a.length() != b.length())
//			return false;
//
//		a = a.toLowerCase();
//		b = b.toLowerCase();
//
//// populate a map with letters and frequencies of String b
//		Map<Character, Integer> map = new HashMap<>();
//
//		for (int k = 0; k < b.length(); k++) {
//			char letter = b.charAt(k);
//
//			if (!map.containsKey(letter)) {
//				map.put(letter, 1);
//			} else {
//				Integer frequency = map.get(letter);
//				map.put(letter, ++frequency);
//			}
//		}
//
//// test each letter in String a against data in the map
//// return if letter is absent in the map or its  frequency is 0
//// otherwise decrease the frequency by 1
//
//		for (int k = 0; k < a.length(); k++) {
//			char letter = a.charAt(k);
//
//			if (!map.containsKey(letter))
//				return false;
//
//			Integer frequency = map.get(letter);
//
//			if (frequency == 0)
//				return false;
//			else
//				map.put(letter, --frequency);
//		}
//// if the code got that far it is an anagram
//		return true;
//	}
//
//	public static void main(String[] args) {
//		
//        System.out.println("Scrivi la due che vuoi capire se siano un anagramma di loro: ");
//		Scanner scan = new Scanner(System.in);
//		String a = scan.next();
//		String b = scan.next();
//		scan.close();
//		boolean ret = isAnagram(a, b);
//		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
//	}

//	    public static void main(String[] args) {
//	        Scanner scan = new Scanner(System.in);
//
//	        // Write your code here.
//           if(!scan.hasNext()) { System.out.print("0"); return; }
//
//            String s = scan.nextLine();
//            String[] items = s.trim().split("[ !,?.\\_'@]+");
//
//            if(s == ""){
//               System.out.println("0");
//            }
//            else if(s.length() > 400000){
//                return;
//            }
//            else{
//               System.out.println(items.length);
//            }
//
//            for(String item: items){
//                System.out.println(item.toString());
//            }
//            scan.close();
//        }

//	public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String IP = in.next();
//            System.out.println(IP.matches(new myRegex().pattern));
//        }
//
//    }

//}

class myRegex {
	public String pattern = "((([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5]))\\b";
}
