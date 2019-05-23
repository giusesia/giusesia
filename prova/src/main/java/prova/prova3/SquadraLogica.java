package prova.prova3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquadraLogica {

	private String nomeFile;
	private List<Squadra> listaSquadre;

	public SquadraLogica(String f) throws Exception {
		nomeFile = f;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomeFile)));
		listaSquadre = new ArrayList<Squadra>();
		Squadra sq = Squadra.read(br);
		while (sq != null) {
			listaSquadre.add(sq);
			sq = Squadra.read(br);
		}

	}

	public List<Squadra> squadraConPiùPunti() throws Exception {
		Stream<Squadra> squadraStream = listaSquadre.stream()
				.sorted(Comparator.comparing(Squadra::getPuntiSquadra).reversed());
		List<Squadra> listaSquadre = squadraStream.collect(Collectors.toList());

		return listaSquadre;

	}

	public Squadra squadraCapPiùGiovane(boolean b) {
		Squadra capPiùGiovane;
		if(b) {
			Stream<Squadra> squadraSteam=listaSquadre.stream().sorted(Comparator.comparing(Squadra::getEtàCapitano));
			capPiùGiovane = squadraSteam.collect(Collectors.toList()).get(0);
		}else {
			Stream<Squadra> squadraSteam=listaSquadre.stream().sorted(Comparator.comparing(Squadra::getEtàCapitano).reversed());
			capPiùGiovane = squadraSteam.collect(Collectors.toList()).get(0);
		}
		return capPiùGiovane;
	}

}
