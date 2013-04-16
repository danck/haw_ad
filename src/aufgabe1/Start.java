package aufgabe1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		int folgenlaenge = 100;
		int min = -100;
		int max = 100;
		try {
			folgenerzeuger.zufallsFolge(min, max, folgenlaenge);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Exel exel = new Exel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int[] seq = new int[folgenlaenge];
		try {
			seq = ReaderWriter.getSequence("./Files/folge.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SequenceSort.maxteilsumme2(seq);
		SequenceSort.maxteilsumme3(seq);
		System.out.print("\n" + SequenceSort.maxteilsummeRekursiv(seq));

	}

}