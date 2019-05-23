package prova.web;

public class CalcoloSfera {
	
	static double pigreco = 3.14;
	
	
	public static double calcoloSfera(double raggio) {
		
		double prigrecotrequarti= (pigreco*4)/3;
		
		return ((raggio*raggio*raggio)*prigrecotrequarti);
	}
	
	public static double calcoloArea(double raggio) {
//area cerchio equatoriale	
		return ((raggio*raggio)*pigreco);
	}

	public static double calcoloCirconferenza(double raggio) {
		// 4Pigreco*r^2;
		return ((raggio*raggio)*4*pigreco);
	}

}
