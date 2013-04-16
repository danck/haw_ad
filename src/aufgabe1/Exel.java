package aufgabe1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exel {
	
	private final FileWriter schreiber;

	public Exel() throws IOException{
		File exel = new File("./Files/maxteilsummeTest.csv");
		this.schreiber = new FileWriter(exel);
		schreiber.write("Anzahl;Algorithmus;maxTeilsumme;Index1;Index2;" +
				"Zeit (inkl. Zählen);Zeit (exkl. Zählen);Summe aller Zugriffe");
		schreiber.flush();
	}
}
