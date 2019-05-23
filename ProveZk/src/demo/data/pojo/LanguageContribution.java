package demo.data.pojo;

public class LanguageContribution {
	
	private String lingua;
	private String autore;
	private String iso;


	public LanguageContribution(String lingua, String autore, String iso) {
		this.lingua=lingua;
		this.autore=autore;
		this.iso=iso;
	}


	public String getLingua() {
		return lingua;
	}


	public void setLingua(String lingua) {
		this.lingua = lingua;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}

	
	
}
