package systems.crigges.unused;

public class Zins {

	public static void main(String[] args) {
		float rate = 150;
		float zinsen = 10;
		float laufzeit = 30;
		
		float zinsenr = 1 + zinsen / 100f;
		System.out.println((rate * 12) * zinsenr * (Math.pow(zinsenr, laufzeit) - 1) / (zinsenr - 1));
	}

}
