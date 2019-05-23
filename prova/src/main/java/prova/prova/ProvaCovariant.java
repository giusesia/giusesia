package prova.prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cibo {
    public String whatsYourName(){
        return "I have many names and types";
 }
}

class Flower {
    public String whatsYourName(){
        return "I have many names and types";
 }
}
class Jasmine extends Flower{
    @Override
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Pizza2 extends Cibo{
    @Override
    public String whatsYourName() {
        return "Pizza";
    }
}

class Anduja extends Cibo{
	@Override
	public String whatsYourName() {
		return "Anduja";
	}
}

class Lily extends Flower{
    @Override
    public String whatsYourName() {
        return "Lily";
    }
}

class Region {
    public Flower yourNationalFlower(){
        return new Flower();
    }
    public Cibo yourNationalCibo(){
        return new Cibo();
    }
    public String tifo() {
		return "";
	}
}

class WestBengal extends Region{
    @Override
    public Jasmine yourNationalFlower(){
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    @Override
    public Lily yourNationalFlower(){
        return new Lily();
    }
}

class Napoli extends Region{
	@Override
	public Pizza2 yourNationalCibo() {
		return new Pizza2();
	}
	@Override
	public String tifo() {
		return "Forza Napoli";
	}
}

class Grisolia extends Region{
	@Override
	public Anduja yourNationalCibo(){
		return new Anduja();
	}
	@Override
	public String tifo() {
		return "Forza Parco La Quiete";
	}
}


public class ProvaCovariant {
  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Inserisci la Regione o Città: ");
      String s = reader.readLine().trim();
      Region region = null;
      switch (s) {
        case "WestBengal":
          region = new WestBengal();
          break;
        case "AndhraPradesh":
          region = new AndhraPradesh();
          break;
        case "Napoli":
          region = new Napoli();
          break;
        case "Campania":
          region = new Napoli();
          break;  
        case "Grisolia":
          region = new Grisolia();
          break;  
        case "Calabria":
          region = new Grisolia();
          break;    
      }
      Flower flower = region.yourNationalFlower();
      if(!"I have many names and types".equals(flower.whatsYourName())) {
          System.out.println(flower.whatsYourName());
      }
      Cibo cibo = region.yourNationalCibo();
      if(!"I have many names and types".equals(cibo.whatsYourName())) {
          System.out.println(cibo.whatsYourName());
                    
          System.out.println(region.tifo());
      }

    }
}