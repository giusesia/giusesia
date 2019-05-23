package prova.prova2;

import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

class ProvaListinoAuto {
	public static void main(String[] args) throws Exception {
		ListinoAuto list = new ListinoAuto(
				"C:\\Users\\gsiano\\eclipse-workspace\\prova\\src\\main\\java\\prova\\prova2\\auto.txt");
		Map<String, Integer> mappa = list.contaAutoNuoveEcontaAutoTotali();
		System.out.println("ECCO La Auto Ordinate per Marca");
		list.autoOrdinate();
		System.out.println("FINE Auto Ordinate per Marca");
		int totali = mappa.get("TOTALI");
		int c = mappa.get("NUOVE");
		System.out.println("Numero di auto totali = " + totali);
		System.out.println("Numero di auto nuove = " + c);
		System.out.println("Numero di auto vecchie = " + (totali - c));
		Auto a = list.autoPiuCostosa();
		System.out.print("L'auto piu' costosa e' la ");
		a.stampa();
		Auto aC = list.autoMenoCostosa();
		System.out.print("L'auto meno' costosa e' la ");
		aC.stampa();
		Auto aKm = list.autoPiuKm();
		System.out.print("L'auto con più KM di media e'");
		aKm.stampa();
		System.out.println("\n media km/anno Matricolazione");
		Vector<?> v = list.medieKmMatricolazione();
		Enumeration<?> en = v.elements();
		while (en.hasMoreElements()) {
			Media m = (Media) en.nextElement();
			System.out.println("marca: " + m.getMarca());
			System.out.println("anno: " + m.getAnno());
			System.out.println("media:" + m.getMedia());
		}
	}
}
