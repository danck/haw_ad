package aufgabe1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Erzeugt eine Zufallsfolge und schreibt diese in die Datei "z:/folge.dat"
 * 
 * @param lowerBound untere Schranke des Intervalls
 * @param upperBound obere Schranke des Intervalls
 * @param anzahl Anzahl der Elemente
 * @throws FileNotFoundException
 * @throws IOException
*/

public class FolgenErzeuger {

	public void zufallsFolge(int lowerBound, int upperBound, int anzahl) throws FileNotFoundException, IOException{
		Random randomizer = new Random();
		File datei = new File("./Files/folge.dat");
		FileWriter schreiber = new FileWriter(datei);

		for (int i=0;i<anzahl;i++) {
			int zufallszahl = (lowerBound + randomizer.nextInt((upperBound+1) - lowerBound));
			schreiber.write(zufallszahl + " ");
		}
		schreiber.flush();
		schreiber.close();
	 }
	
}
