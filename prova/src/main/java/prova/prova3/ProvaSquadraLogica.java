package prova.prova3;

import java.util.Scanner;

public class ProvaSquadraLogica {
	public static boolean d = true;
	private static Scanner scan;
	
	public static void main(String[]args) throws Exception {
		
		while (d==true) {

			scan = new Scanner(System.in);
			
			System.out.println("Cosa ti Interessa sapere ( Classifica, Squadra Più Punti, Squadra Meno Punti, Capitano più giovane o Capitano più anziano: ");
			String opzione = scan.nextLine();
			System.out.println("OpzioneScelta: "+opzione);
			SquadraLogica list = new SquadraLogica(
					"C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova3\\squadra.txt");
	       if("Squadra Più Punti".equalsIgnoreCase(opzione)) {
	    	   Squadra squadraPiuPunti = list.squadraConPiùPunti().get(0);
	           squadraPiuPunti.stampa();
	          
	       }
	       else if("Squadra Meno Punti".equalsIgnoreCase(opzione)) {
	    	   int size = list.squadraConPiùPunti().size();
	    	   Squadra squadraPiuPunti = list.squadraConPiùPunti().get(size-1);
	           squadraPiuPunti.stampa();
	          
	       }
	       else if("Classifica".equalsIgnoreCase(opzione)) {
	    	   System.out.println("Tutte le Squadre: ");
	           for (Squadra squadra : list.squadraConPiùPunti()) {
	   			squadra.stampa();
	   		}
	           System.out.println("Fine Tutte le Squadre");
	         
	       }else if("Capitano più giovane".equalsIgnoreCase(opzione)) {
	    	   System.out.println("La Squadra con il Capitano più giovane è: ");
	           Squadra squadraCapPiùGiovane = list.squadraCapPiùGiovane(true);
	           squadraCapPiùGiovane.stampa();
	       }else if("Capitano più anziano".equalsIgnoreCase(opzione)) {
	    	   System.out.println("La Squadra con il Capitano più anziano è: ");
	           Squadra squadraCapPiùAnziano = list.squadraCapPiùGiovane(false);
	           squadraCapPiùAnziano.stampa();
	       }else {
	    	   System.out.println("Opzione non prevista!!!!!");
	       }
	       System.out.println("Vuoi continuare?  Si  No");
			String risp;
			risp =scan.next(); 
			if(risp.equals("No") | risp.equals("no")| risp.equals("n")| risp.equals("N")){
				d=false;
				scan.close();
				break;

			}

		}
	}

}
