package iscs.siano.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iscs.siano.oggetto.Oggetto;

public class Utility {
	
	public static String calcoloDifferenza(int massima, int minima) {
		String calcolo = String.valueOf(massima - minima);
		return calcolo;
	}
	
	
	public static Oggetto calcoloDifferenzaMinima(List<Oggetto> lista) {

		Oggetto oggettoMinimaDifferenza = lista.get(0);
		int minimoValore = 99;
		List<String> str = new ArrayList<String>();
		System.out.println("the list: ");
		lista.forEach((i) -> {
			if(Integer.valueOf(i.getProprietà())>0) {
				str.add(StringUtils.leftPad(i.getProprietà(), 2, '0'));
			}
		});
		str.stream();
		System.out.println("");
		
		String minNumber2 = str.stream()
		        .min(Comparator.comparing(i -> i)).get();
		String maxNumber2 = str.stream()
		        .max(Comparator.comparing(i -> i)).get();
		
		System.out.println("minNumber: "+minNumber2.replaceFirst("0", ""));
		System.out.println("maxNumber "+maxNumber2);

		for (Oggetto oggetto : lista) {
			int valoreDifferenzaReti= Integer.valueOf(oggetto.getProprietà());
			minimoValore=Integer.valueOf(minNumber2); 
			if(minimoValore==valoreDifferenzaReti) {
				oggettoMinimaDifferenza.setOggettoParticolare(oggetto.getOggettoParticolare());
				oggettoMinimaDifferenza.setProprietà(oggetto.getProprietà());
			}
		}
		return oggettoMinimaDifferenza;
	}

}
