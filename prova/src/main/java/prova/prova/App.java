package prova.prova;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner input;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		String nome = "Ghiusehppe";
		String cognome = "Sianho";

		String valore = sistemaNome(nome, cognome);

		System.out.println("Chiamata Metodo SistemaNome Finito " + valore);

		String valoreMore = sistemaNomeMore(nome, cognome);

		System.out.println("Chiamata Metodo sistemaNomeMore Finito " + valoreMore);

		provaJava8();
	}

	private static String sistemaNome(String nome, String cognome) {

		String valoreCheVoglioCreare = "";

		String catturaValoreDaCacciare = getValue("h", nome);
		valoreCheVoglioCreare = catturaValoreDaCacciare + " " + cognome;

		return valoreCheVoglioCreare;

	}

	private static String sistemaNomeMore(String nome, String cognome) {

		String valoreCheVoglioCreare = "";

		List<String> catturaValoreDaCacciare = getValueMoreValue("h", nome, cognome);
//		 valoreCheVoglioCreare = catturaValoreDaCacciare+" " + nome; 
		for (String string : catturaValoreDaCacciare) {
			valoreCheVoglioCreare = valoreCheVoglioCreare.concat(" " + string);
		}

		return valoreCheVoglioCreare;

	}

	private static String getValue(String s, String nome) {

		String v1 = "";
		for (int i = 0; i < nome.length(); i++) {
			StringBuilder s1Sub = new StringBuilder(nome.substring(i, i + 1));
			if (s.equals(s1Sub.toString())) {

			} else {
				v1 = v1.concat(s1Sub.toString());
			}
		}

		return v1;
	}

	private static List<String> getValueMoreValue(String s, String nome, String cognome) {

		String v1 = "";
		String v2 = "";
		for (int i = 0; i < nome.length(); i++) {
			StringBuilder s1Sub = new StringBuilder(nome.substring(i, i + 1));
			if (s.equals(s1Sub.toString())) {

			} else {
				v1 = v1.concat(s1Sub.toString());
			}
		}

		for (int i = 0; i < cognome.length(); i++) {
			StringBuilder s1Sub = new StringBuilder(cognome.substring(i, i + 1));
			if (s.equals(s1Sub.toString())) {
				System.out.println("Entrato con " + s1Sub.toString());
			} else {
				v2 = v2.concat(s1Sub.toString());
			}
		}

		List<String> vList = new ArrayList<String>();

		vList.add(v1);
		vList.add(v2);

		return vList;
	}

	public static void provaJava8() {

		// Creazione di uno Stream da un elenco di interi
		Stream<Integer> stream = Stream.of(new Integer[] { 1, 2, 3, 4 });
		stream.forEach(System.out::println);
		// Crea uno Stream da un elenco di stringhe e stampa l'elenco sullo schermo
		Stream.of("Questo", "è", "uno", "Stream", "Java8").forEach(System.out::println);

		String pathinput = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\File.txt";

		// Creazione di uno Stream da un array di oggetti Integer
		Stream<Integer> stream2 = Stream.of(new Integer[] { 5, 1, 2, 3, 4 });
		stream2.sorted().forEach(System.out::println);
		// Crea uno stream da un array di stringhe e stampa tutti gli elementi sullo
		// schermo
		String[] stringArray = new String[] { "Streams", "can", "be", "created", "from", "arrays" };
		Arrays.stream(stringArray).forEach(System.out::println);

		// Crea un BufferedReader per un file
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(pathinput), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Il metodo lines() di BufferedReader's restituisce uno stream di tutte le
		// linee lette dal file
		Stream<String> lista = reader.lines();
		// Creo una sort dalla lista degli stream recuperati dal file
		Stream<String> listaSortata = lista.sorted();
		listaSortata.forEach(System.out::println);

		List<String> cities = Arrays.asList("milano", "london", "San Francisco", "Tokyo", "New Delhi", "Napoli");
		System.out.println(cities);
		// [milano, london, San Francisco, Tokyo, New Delhi, Napoli]

		cities.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(cities);
		// [london, milano, Napoli, New Delhi, San Francisco, Tokyo]

		cities.sort(Comparator.naturalOrder());
		System.out.println(cities);
		// [Napoli, New Delhi, San Francisco, Tokyo, london, milano]

		String pathScrittura = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\FileOutput.txt";

		try {
			scriviFile(cities, pathScrittura, false);
		} catch (IOException e) {

			e.printStackTrace();
		}
		// Utilizzo Java8
		String pathScrittura8 = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\FileOutput8.txt";

		try {
			scriviFile(cities, pathScrittura8, true);
		} catch (IOException e) {

			e.printStackTrace();
		}

		creaBufferStream(pathinput, null, false);
		System.out.println("Scrivi Parola che vuoi eliminare : ");
		input = new Scanner(System.in);
		String parolaDaEliminare = input.nextLine();
		System.out.println("Elimino : " + parolaDaEliminare);

//		String parolaDaEliminare="milano";
		// ordino ed elimino
		creaBufferStream(pathinput, parolaDaEliminare, true);
		// elimino
		creaBufferStream(pathinput, parolaDaEliminare, false);
	}

	private static void scriviFile(List<String> cities, String pathScrittura, boolean b) throws IOException {

		if (b) {
			System.out.println("Scrivo Nel FileJava8");

			FileWriter writer = new FileWriter(pathScrittura);

			writer.write(cities.toString());
			writer.close();
		} else {
			System.out.println("Scrivo Nel File");

			FileWriter writer = new FileWriter(pathScrittura);

			for (String str : cities) {
				writer.write(str.concat(", "));
			}
			writer.close();

		}

	}

	public static void creaBufferStream(String pathInput, String parolaDaEliminare, boolean valoreOrdinamento) {
		List<String> list = new ArrayList<String>();
		try (BufferedReader buff = Files.newBufferedReader(Paths.get(pathInput), StandardCharsets.UTF_8)) {
			list = buff.lines().collect(Collectors.toList());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		if (parolaDaEliminare != null && !valoreOrdinamento) {
			list = modificaParametri(list, parolaDaEliminare, false);

			String pathScrittura8DaFileSenzaParola = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\FileOutput8DaFileSenzaParola.txt";

			try {
				scriviFile8DaFileLogica(list, pathScrittura8DaFileSenzaParola, parolaDaEliminare, false);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else if (parolaDaEliminare != null && valoreOrdinamento) {
			list = modificaParametri(list, parolaDaEliminare, true);

			String pathScrittura8DaFileSenzaParola = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\FileOutput8DaFileSenzaParolaOrdinata.txt";

			try {
				scriviFile8DaFileLogica(list, pathScrittura8DaFileSenzaParola, parolaDaEliminare, true);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			list = modificaParametri(list, null, false);

			String pathScrittura8DaFile = "C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova\\FileOutput8DaFile.txt";

			try {
				scriviFile8DaFileLogica(list, pathScrittura8DaFile, null, false);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	private static List<String> modificaParametri(List<String> list, String parolaDaEliminare,
			boolean valoreOrdinamento) {
		List<String> result = new ArrayList<String>();
		// Elimino la parola
		if (parolaDaEliminare != null && !valoreOrdinamento) {
			result = (List<String>) list.stream().filter(line -> !parolaDaEliminare.equals(line))
					.collect(Collectors.toList());
			return result;
			// Elimino la parola e faccio anche ordinamento
		} else if (parolaDaEliminare != null && valoreOrdinamento) {
			result = (List<String>) list.stream().filter(line -> !parolaDaEliminare.equals(line)).sorted()
					.collect(Collectors.toList());
			return result;
		} else {
			list.sort(Comparator.naturalOrder());
			return list;
		}

	}

	private static void scriviFile8DaFileLogica(List<String> list, String pathScrittura8DaFile, String conParola,
			boolean ordinato) throws IOException {

		if (conParola != null && !ordinato) {
			FileWriter writer = new FileWriter(pathScrittura8DaFile);
			writer.write(list.toString());
			writer.close();
		} else if (conParola != null && ordinato) {
			FileWriter writer = new FileWriter(pathScrittura8DaFile);
			writer.write(list.toString());

			writer.close();
		} else {
			FileWriter writer = new FileWriter(pathScrittura8DaFile);
			writer.write(list.toString());

			writer.close();
		}
	}

}
