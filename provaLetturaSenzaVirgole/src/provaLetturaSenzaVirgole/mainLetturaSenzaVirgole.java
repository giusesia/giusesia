package provaLetturaSenzaVirgole;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class mainLetturaSenzaVirgole {

	public static void main(String[] args) throws FileNotFoundException, IOException {
        
		//METEO
		// definiamo il percorso al file da leggere
		String doc = "C:\\Users\\gsiano\\eclipse-workspace\\provaLetturaSenzaVirgole\\src\\weather.dat";
		List<Oggetto> lista = Utility.creaOggettoConLettura(doc, Oggetto.METEO);
		String pathScrittura = "C:\\Users\\gsiano\\eclipse-workspace\\provaLetturaSenzaVirgole\\src\\FileOutputMeteo.txt";

		Oggetto giornoConMinimaEscursione = Utility.calcoloDifferenzaMinima(lista);
		System.out.println("--------------------");
		System.out.println("Giorno Minore Escursione è il : " + giornoConMinimaEscursione.getPrimaProprietà().trim());
		System.out.println("--------------------");
		Utility.scriviFile(giornoConMinimaEscursione, pathScrittura, Oggetto.METEO);
		
		//CALCIO

		String docCalcio = "C:\\Users\\gsiano\\eclipse-workspace\\provaLetturaSenzaVirgole\\src\\football.dat";

		List<Oggetto> listaCalcio = Utility.creaOggettoConLettura(docCalcio, Oggetto.FOOTBALL);
		String pathScritturaCalcio = "C:\\Users\\gsiano\\eclipse-workspace\\provaLetturaSenzaVirgole\\src\\FileOutputCalcio.txt";

		Oggetto squadraConMinimaDifferenzaReti = Utility.calcoloDifferenzaMinima(listaCalcio);
		System.out.println("--------------------");
		System.out.println("Squadra Minore Diffenza reti è il : " + squadraConMinimaDifferenzaReti.getPrimaProprietà().trim());
		System.out.println("--------------------");
		Utility.scriviFile(squadraConMinimaDifferenzaReti, pathScritturaCalcio, Oggetto.FOOTBALL);

	}


}
