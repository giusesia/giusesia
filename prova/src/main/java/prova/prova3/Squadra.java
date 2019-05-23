package prova.prova3;

import java.io.BufferedReader;


public class Squadra {
	
	private String nomeSquadra;
	private String capitano;
	private int puntiSquadra;
	private int etàCapitano;
	public Squadra(String nomeSquadra, String capitano, int etàCapitano, int puntiSquadra) {

		this.nomeSquadra = nomeSquadra;
		this.capitano = capitano;
		this.puntiSquadra = puntiSquadra;
		this.etàCapitano = etàCapitano;
	}
	public String getNomeSquadra() {
		return nomeSquadra;
	}
	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}
	public String getCapitano() {
		return capitano;
	}
	public void setCapitano(String capitano) {
		this.capitano = capitano;
	}
	public int getPuntiSquadra() {
		return puntiSquadra;
	}
	public void setPuntiSquadra(int puntiSquadra) {
		this.puntiSquadra = puntiSquadra;
	}
	public int getEtàCapitano() {
		return etàCapitano;
	}
	public void setEtàCapitano(int etàCapitano) {
		this.etàCapitano = etàCapitano;
	}
	
	public void stampa() {
		System.out.println(nomeSquadra+" con Punti Squadra "+puntiSquadra+" ha Capitano "+capitano+" Età Capitano "+etàCapitano+"");
	}
	 public static Squadra read (BufferedReader br) throws Exception
	  {
	    String s=br.readLine();
	    if (s==null) 
	      return null;
	    else
	      return new Squadra(s,br.readLine(),
	                        Integer.parseInt(br.readLine()),
	                        Integer.parseInt(br.readLine()) );
	  }

}
