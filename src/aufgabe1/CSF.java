package aufgabe1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSF {
	
	private final FileWriter schreiber;

	public CSF() throws IOException{
		File exel = new File("./Files/maxteilsummeTest.csv");
		this.schreiber = new FileWriter(exel);
		schreiber.write("Anzahl;Algorithmus;maxTeilsumme;Index1;Index2;" +
				"Zeit (inkl. Zählen);Zeit (exkl. Zählen);Summe aller Zugriffe;Matrix-Zugriffe;;\n");
		schreiber.flush();
	}
	
	public void neuerEintrag(String s) throws IOException{
		schreiber.write(s+";");
	}
	
	public void newLine() throws IOException{
		schreiber.write("\n");
	}
	
	public void close() throws IOException{
		schreiber.close();
	}
}
