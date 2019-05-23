package iscs.siano.calcio;

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

public class mainCalcio {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// definiamo il percorso al file da leggere
		File doc = new File("C:\\Users\\gsiano\\Downloads\\CompitoGiuseppeSianoColloquioISCS/football.dat");
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

			String line2 = scanner.nextLine();
			if (!line2.isEmpty() && !line2.contains("----")) {
				String[] line2Split = line2.split(";");
				Oggetto oggetto = new Oggetto();
				oggetto.setOggettoParticolare(line2Split[1]);
				int golFatti = Integer.parseInt(line2Split[6].trim());
				int golSubiti = Integer.parseInt(line2Split[7].trim());
				String differenzaReti = Utility.calcoloDifferenza(golFatti, golSubiti);

				oggetto.setProprietà(differenzaReti);

				System.out.println("Squadra: " + line2Split[1] + " DifferenzaReti: " + differenzaReti);
				lista.add(oggetto);

			}

		}
		String pathScrittura = "C:\\Users\\gsiano\\eclipse-workspace\\provaDifferenze\\src\\iscs\\siano\\calcio\\FileOutputCalcio.txt";

		Oggetto squadraConMinimaDifferenzaReti = Utility.calcoloDifferenzaMinima(lista);
		System.out.println("--------------------");
		System.out.println("La Squadra con Minore Differenza Reti è: "
				+ squadraConMinimaDifferenzaReti.getOggettoParticolare().trim());
		System.out.println("--------------------");
		scriviFile(squadraConMinimaDifferenzaReti, pathScrittura);

	}

	private static void scriviFile(Oggetto squadra, String pathScrittura) throws IOException {
		System.out.println("Scrivo Nel File");
		FileWriter writer = new FileWriter(pathScrittura);
		writer.write("La Squadra con Minore Differenza Reti è : " + squadra.getOggettoParticolare().trim()
				+ " con differenza reti di : " + squadra.getProprietà() + " reti");
		writer.close();

	}

}
