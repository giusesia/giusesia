package iscs.siano.meteo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import iscs.siano.oggetto.Oggetto;
import iscs.siano.utility.Utility;

public class mainMeteo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// definiamo il percorso al file da leggere
		File doc = new File("C:\\Users\\gsiano\\Downloads\\CompitoGiuseppeSianoColloquioISCS/weather.dat");
		URL path = null;

		// mostriamo il percorso al file
		path = doc.toURL();
		System.out.println("Il doc si trova nel percorso" + path);

		doc = new File(path.getFile());
		System.out.println("Nome del file " + doc);
		int i;

		// apriamo lo stream di input...
		InputStream is = path.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		Scanner scanner = new Scanner(doc);
		scanner.nextLine();
		List<Oggetto> lista = new ArrayList<Oggetto>();
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			if (!line.isEmpty()) {
				String[] lineSplit = line.split(";");
				Oggetto oggetto = new Oggetto();
				oggetto.setOggettoParticolare(lineSplit[0]);
				int massima = Integer.parseInt(lineSplit[1].trim());
				int minima = Integer.parseInt(lineSplit[2].trim());
				String escursione = Utility.calcoloDifferenza(massima, minima);

				oggetto.setProprietà(escursione);

				System.out.println("Giorno:" + lineSplit[0] + " Escursione: " + escursione);
				lista.add(oggetto);

			}

		}
		String pathScrittura = "C:\\Users\\gsiano\\eclipse-workspace\\provaDifferenze\\src\\iscs\\siano\\meteo\\FileOutputMeteo.txt";

		Oggetto giornoConMinimaEscursione = Utility.calcoloDifferenzaMinima(lista);
		System.out.println("--------------------");
		System.out
				.println("Giorno Minore Escursione è il : " + giornoConMinimaEscursione.getOggettoParticolare().trim());
		System.out.println("--------------------");
		scriviFile(giornoConMinimaEscursione, pathScrittura);

	}

	private static void scriviFile(Oggetto giorno, String pathScrittura) throws IOException {
		System.out.println("Scrivo Nel File");
		FileWriter writer = new FileWriter(pathScrittura);
		writer.write("Giorno Minore Escursione è il : " + giorno.getOggettoParticolare().trim()
				+ " con escursione di : " + giorno.getProprietà());
		writer.close();

	}

}
