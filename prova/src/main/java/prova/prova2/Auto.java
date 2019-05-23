package prova.prova2;

import java.io.*;

class Auto {

  private String marca;
  private int anno;
  private int Km;
  private int prezzo;

  public Auto (String m, int a, int km, int p) {
    marca=m; anno=a; Km=km; prezzo=p;
  }

  public void stampa() {
    System.out.println(marca+" Anno "+anno+" con Km "+Km+" costa "+prezzo+" euro");
  }


  public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public int getAnno() {
	return anno;
}

public void setAnno(int anno) {
	this.anno = anno;
}

public int getKm() {
	return Km;
}

public void setKm(int km) {
	Km = km;
}

public int getPrezzo() {
	return prezzo;
}

public void setPrezzo(int prezzo) {
	this.prezzo = prezzo;
}

public void modificaPrezzo(int p) {
    prezzo=p;
  }
  
  

  public static Auto read (BufferedReader br) throws Exception
  {
    String s=br.readLine();
    if (s==null) 
      return null;
    else
      return new Auto(s,Integer.parseInt(br.readLine()),
                        Integer.parseInt(br.readLine()),
                        Integer.parseInt(br.readLine()) );
  }

}