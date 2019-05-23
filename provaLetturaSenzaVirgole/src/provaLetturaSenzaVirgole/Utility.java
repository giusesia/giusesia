package provaLetturaSenzaVirgole;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;



public class Utility {

	public static String calcoloDifferenza(int massima, int minima) {
		String calcolo = String.valueOf(massima - minima);
		return calcolo;
	}

	public static Oggetto calcoloDifferenzaMinima(List<Oggetto> lista) {

		Oggetto oggettoMinimaDifferenza = lista.get(0);
		int minimoValore = 99;
		List<String> str = new ArrayList<String>();
		lista.forEach((i) -> {
			if (Integer.valueOf(i.getSecondaProprietà()) > 0) {
				str.add(StringUtils.leftPad(i.getSecondaProprietà(), 2, '0'));
			}
		});
		str.stream();
		System.out.println("");

		String minNumber2 = str.stream().min(Comparator.comparing(i -> i)).get();
		String maxNumber2 = str.stream().max(Comparator.comparing(i -> i)).get();

		System.out.println("minNumber: " + minNumber2.replaceFirst("0", ""));
		System.out.println("maxNumber " + maxNumber2);

		for (Oggetto oggetto : lista) {
			int valoreDifferenzaReti = Integer.valueOf(oggetto.getSecondaProprietà());
			minimoValore = Integer.valueOf(minNumber2);
			if (minimoValore == valoreDifferenzaReti) {
				oggettoMinimaDifferenza.setPrimaProprietà(oggetto.getPrimaProprietà());
				oggettoMinimaDifferenza.setSecondaProprietà(oggetto.getSecondaProprietà());
			}
		}
		return oggettoMinimaDifferenza;
	}
	
	public static List<Oggetto> creaOggettoConLettura(String pathInput, String elemento) throws IOException {

		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(pathInput), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(reader);
		scanner.nextLine();
		List<Oggetto> lista = new ArrayList<Oggetto>();
		if(elemento.equalsIgnoreCase(Oggetto.METEO)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.isEmpty()) {
					String s2 = line.replaceAll(" {2,}", " ");
					s2.trim();
					String[] lineSplit = s2.split(" ");
					Oggetto oggetto = new Oggetto();
					oggetto.setPrimaProprietà(lineSplit[1]);
					int massima = Integer.parseInt(lineSplit[2].trim());
					int minima = Integer.parseInt(lineSplit[3].trim());
					String escursione = Utility.calcoloDifferenza(massima, minima);
					oggetto.setSecondaProprietà(escursione);
					lista.add(oggetto);
				}
			}
		}else if(elemento.equalsIgnoreCase(Oggetto.FOOTBALL)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
		// Se volessi utilizzare gli Optional		
//				String s = Optional.ofNullable(line).orElse("");
//				if (!s.trim().isEmpty()) {
//				    ...
//				}
				if (!line.isEmpty()) {
					String s2 = line.replaceAll(" {2,}", " ");
					s2.trim();
					String[] lineSplit = s2.split(" ");
					if (!lineSplit[1].equals("-------------------------------------------------------")) {
						Oggetto oggetto = new Oggetto();
						oggetto.setPrimaProprietà(lineSplit[2]);
						int massima = Integer.parseInt(lineSplit[7].trim());
						int minima = Integer.parseInt(lineSplit[9].trim());
						String escursione = Utility.calcoloDifferenza(massima, minima);
						oggetto.setSecondaProprietà(escursione);
						lista.add(oggetto);
					}
				}
			}
		}
		scanner.close();
		return lista;
	}
	
	public static void scriviFile(Oggetto oggetto, String pathScrittura, String elemento) throws IOException {
		System.out.println("Scrivo Nel File");
		FileWriter writer = new FileWriter(pathScrittura);
		if(elemento.equalsIgnoreCase(Oggetto.METEO)) {
			writer.write("Giorno Minore Escursione è il : " + oggetto.getPrimaProprietà().trim() + " con escursione di : "
					+ oggetto.getSecondaProprietà());
		}else if(elemento.equalsIgnoreCase(Oggetto.FOOTBALL)) {
			writer.write("Squadra Minore Diffenza reti è il : " + oggetto.getPrimaProprietà().trim()
			+ " con differenza reti di : " + oggetto.getSecondaProprietà());
		}

		writer.close();

	}

}
