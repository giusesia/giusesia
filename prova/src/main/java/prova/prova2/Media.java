package prova.prova2;

public class Media {
	
	private int anno;
	private int media;
	private String marca;

	public Media(String marca, int anno, int media) {
		this.marca=marca;
		this.anno=anno;
		this.media=media;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


}
