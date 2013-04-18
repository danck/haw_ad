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
		
		starte(-100,100,100,csv);
		csv.newLine();
		starte(-100,100,200,csv);
		csv.newLine();
		starte(-100,100,300,csv);
		csv.newLine();
		starte(-100,100,400,csv);
		csv.newLine();
		starte(-100,100,500,csv);
		csv.newLine();
		starte(-100,100,600,csv);
		csv.newLine();
		starte(-100,100,700,csv);
		csv.newLine();
		starte(-100,100,800,csv);
		csv.newLine();
		starte(-100,100,900,csv);
		csv.newLine();
		starte(-100,100,1000,csv);
		
		
		
		csv.close();
		System.out.println("maxteilsummeTest.csv angelegt.");

	}
	
	public static void starte(int min, int max, int folgenlaenge, CSV csv) throws IOException{
		
		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		folgenerzeuger.zufallsFolge(min, max, folgenlaenge);
		int[] seq = new int[folgenlaenge];
		seq = Reader.getSequence("./Files/folge.dat");
		
//		int[] seq = new int[]{-10 ,86 ,83 ,-93 ,56 ,98 ,77 ,-37 ,81 ,76 ,-92 ,78 ,1 ,-52 ,-27 ,71 ,-44 ,26 ,60 ,83}; //feste folge zum debugen
		
		//maxteilsumme3
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
		
		//maxteilsumme2 mit oben erzeugter Folge durchfuehren und Ergebniss in csv-Datei schreiben
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
		
		//maxteilsummeRekursiv
		csv.neuerEintrag(Integer.toString(folgenlaenge));
		csv.neuerEintrag("maxteilsummeRekursiv");
		List<Integer> mtr = SequenceSort.maxTeilsummeRekursiv(seq);
		for(Integer n: mtr){
			csv.neuerEintrag(n.toString());
		}
		csv.neuerEintrag(Integer.toString(SequenceSort.maxteilsummeRekursivZugriffe));
		csv.neuerEintrag(Long.toString(SequenceSort.laufzeit));
		SequenceSortOhneZugriffe.maxTeilsummeRekursiv(seq);
		csv.neuerEintrag(Long.toString(SequenceSortOhneZugriffe.laufzeit));
		
		csv.newLine();
		
		//maxteilsumme1
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