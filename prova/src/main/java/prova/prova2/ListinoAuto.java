package prova.prova2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

class ListinoAuto {

	private String nomefile;
	private Vector<Auto> listino;

	public ListinoAuto(String f) throws Exception {
		nomefile = f;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomefile)));
		listino = new Vector<Auto>();
		Auto a = Auto.read(br);
		while (a != null) {
			listino.addElement(a);
			a = Auto.read(br);
		}
	}

	public Map<String, Integer> contaAutoNuoveEcontaAutoTotali() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomefile)));
		Map<String, Integer> mappa = new HashMap<String, Integer>();
		int totale = listino.size();

		mappa.put("TOTALI", totale);
		List<Auto> result = listino.stream().filter(a -> a.getKm() == 0).collect(Collectors.toList());
		br.close();
		mappa.put("NUOVE", result.size());
		return mappa;
	}

	public Auto autoPiuCostosa() throws Exception {
		Enumeration<Auto> enumListino = listino.elements();

		int max = 0;
		Auto amax = null;
		Auto a;
		while (enumListino.hasMoreElements()) {
			a = (Auto) enumListino.nextElement();
			if (a.getPrezzo() > max) {
				max = a.getPrezzo();
				amax = a;
			}
		}
		return amax;
	}

	public Auto autoMenoCostosa() throws Exception {
		Enumeration<Auto> enumListino = listino.elements();

		int max = 99000000;
		Auto amax = null;
		Auto a;
		while (enumListino.hasMoreElements()) {
			a = (Auto) enumListino.nextElement();
			if (a.getPrezzo() < max) {
				max = a.getPrezzo();
				amax = a;
			}
		}
		return amax;

	}

	public void autoOrdinate() throws Exception {

		Enumeration<Auto> enumListino = listino.elements();
		List<Auto> listaAuto = new ArrayList<Auto>();
		while (enumListino.hasMoreElements()) {
			listaAuto.add(enumListino.nextElement());
		}
		listaAuto.sort(Comparator.comparing(Auto::getMarca).thenComparing(Auto::getAnno));
		for (Auto auto : listaAuto) {
			System.out.println("Marca: " + auto.getMarca() + " " + auto.getPrezzo());
		}

	}

	public Auto autoPiuKm() throws Exception {
		Enumeration<Auto> enumListino = listino.elements();

		int max = 0;
		Auto amax = null;
		Auto a;
		while (enumListino.hasMoreElements()) {
			a = (Auto) enumListino.nextElement();
			if (a.getKm() > max) {
				max = a.getKm();
				amax = a;
			}
		}
		return amax;
	}

	public Vector<Media> medieKmMatricolazione() {
		Auto a;
		int anno, me;
		String marca = "";
		Vector<Media> medie = new Vector<Media>();

		Enumeration<Auto> enListino = listino.elements();
		while (enListino.hasMoreElements()) {
			a = (Auto) enListino.nextElement();
			anno = a.getAnno();
			marca = a.getMarca();
			if (!inLista(marca, anno, medie)) {
				me = calcolaMedia(anno, listino);
				Media media = new Media(marca, anno, me);
				medie.addElement(media);
			}
		}
		return medie;
	}

	private int calcolaMedia(int anno, Vector<Auto> listino) {
		int somma = 0, cont = 0;
		Auto a;
		Enumeration<Auto> en = listino.elements();

		while (en.hasMoreElements()) {
			a = (Auto) en.nextElement();
			if (a.getAnno() == anno) {
				cont++;
				somma += a.getKm();
			}
		}
		if (cont != 0) {
			return somma / cont;
		} else {
			return 0;
		}

	}

	private boolean inLista(String marca, int anno, Vector<Media> medie) {
		Enumeration<Media> en = medie.elements();
		Media media;
		while (en.hasMoreElements()) {
			media = (Media) en.nextElement();
			if (media.getAnno() == anno && (marca).equals(media.getMarca())) {
				return true;
			}

		}
		return false;
	}
}
