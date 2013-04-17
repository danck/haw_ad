package aufgabe1;

import java.io.IOException;
import java.util.List;

public class Start {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		CSV csv = new CSV();
		
		starte(-100,100,1000,csv);
		csv.newLine();
		starte(-100,100,2000,csv);
		csv.newLine();
		starte(-100,100,3000,csv);
		csv.newLine();
		starte(-100,100,4000,csv);
		csv.newLine();
		starte(-100,100,5000,csv);
		csv.newLine();
		starte(-100,100,6000,csv);
		csv.newLine();
		starte(-100,100,7000,csv);
		csv.newLine();
		starte(-100,100,8000,csv);
		csv.newLine();
		starte(-100,100,9000,csv);
		csv.newLine();
		starte(-100,100,10000,csv);
		
		
		
		csv.close();
		System.out.println("maxteilsummeTest.csv angelegt.");

	}
	
	public static void starte(int min, int max, int folgenlaenge, CSV csv) throws IOException{
		
		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		folgenerzeuger.zufallsFolge(min, max, folgenlaenge);
		int[] seq = new int[folgenlaenge];
		seq = Reader.getSequence("./Files/folge.dat");
				
		csv.neuerEintrag(Integer.toString(folgenlaenge));
		csv.neuerEintrag("maxteilsumme3");
		List<Integer> mts3 = SequenceSort.maxTeilsumme3(seq);
		for(Integer n: mts3){
			csv.neuerEintrag(n.toString());
		}
		csv.neuerEintrag(Long.toString(SequenceSort.laufzeit));
		SequenceSortOhneZugriffe.maxTeilsumme3(seq);
		csv.neuerEintrag(Long.toString(SequenceSortOhneZugriffe.laufzeit));
		
		csv.newLine();
		
		csv.neuerEintrag(Integer.toString(folgenlaenge));
		csv.neuerEintrag("maxteilsumme2");
		List<Integer> mts2 = SequenceSort.maxTeilsumme2(seq);
		for(Integer n: mts2){
			csv.neuerEintrag(n.toString());
		}
		csv.neuerEintrag(Long.toString(SequenceSort.laufzeit));
		SequenceSortOhneZugriffe.maxTeilsumme2(seq);
		csv.neuerEintrag(Long.toString(SequenceSortOhneZugriffe.laufzeit));
		csv.neuerEintrag(Integer.toString(SequenceSort.mat_zugriffe));
		SequenceSort.reset();
		
		csv.newLine();
		
		csv.neuerEintrag(Integer.toString(folgenlaenge));
		csv.neuerEintrag("maxteilsummeRekursiv");
		csv.neuerEintrag(Integer.toString(SequenceSort.maxTeilsummeRekursiv(seq)));
		csv.neuerEintrag("N/A");
		csv.neuerEintrag("N/A");
		csv.neuerEintrag(Integer.toString(SequenceSort.maxteilsummeRekursivZugriffe));
		csv.neuerEintrag(Long.toString(SequenceSort.laufzeit));
		SequenceSortOhneZugriffe.maxTeilsummeRekursiv(seq);
		csv.neuerEintrag(Long.toString(SequenceSortOhneZugriffe.laufzeit));
		
		csv.newLine();
		
		csv.neuerEintrag(Integer.toString(folgenlaenge));
		csv.neuerEintrag("maxteilsumme1");
		List<Integer> mts1 = SequenceSort.maxTeilsumme1(seq);
		for(Integer n: mts1){
			csv.neuerEintrag(n.toString());
		}		
		csv.neuerEintrag(Long.toString(SequenceSort.laufzeit));
		SequenceSortOhneZugriffe.maxTeilsumme1(seq);
		csv.neuerEintrag(Long.toString(SequenceSortOhneZugriffe.laufzeit));
	}

}