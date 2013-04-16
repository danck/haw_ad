package aufgabe1;

import java.io.IOException;
import java.util.List;

public class Start {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		CSV cfs = new CSV();
		
		starte(-100,100,100,cfs);
		cfs.newLine();
		starte(-100,100,200,cfs);
		cfs.newLine();
		starte(-100,100,300,cfs);
		cfs.newLine();
		starte(-100,100,400,cfs);
		cfs.newLine();
		starte(-100,100,500,cfs);
		cfs.newLine();
		starte(-100,100,600,cfs);
		cfs.newLine();
		starte(-100,100,700,cfs);
		cfs.newLine();
		starte(-100,100,800,cfs);
		cfs.newLine();
		starte(-100,100,900,cfs);
		cfs.newLine();
		starte(-100,100,1000,cfs);
		
		
		
		cfs.close();

	}
	
	public static void starte(int min, int max, int folgenlaenge, CSV cfs) throws IOException{
		
		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		folgenerzeuger.zufallsFolge(min, max, folgenlaenge);
		int[] seq = new int[folgenlaenge];
		seq = Reader.getSequence("./Files/folge.dat");
		
		cfs.neuerEintrag(Integer.toString(folgenlaenge));
		cfs.neuerEintrag("maxteilsumme3");
		List<Integer> mts3 = SequenceSort.maxTeilsumme3(seq);
		for(Integer n: mts3){
			cfs.neuerEintrag(n.toString());
		}
		
		cfs.newLine();
		
		cfs.neuerEintrag(Integer.toString(folgenlaenge));
		cfs.neuerEintrag("maxteilsumme2");
		List<Integer> mts2 = SequenceSort.maxTeilsumme2(seq);
		for(Integer n: mts2){
			cfs.neuerEintrag(n.toString());
		}
		
		
		cfs.newLine();
		
		cfs.neuerEintrag(Integer.toString(folgenlaenge));
		cfs.neuerEintrag("maxteilsumme1");
		List<Integer> mts1 = SequenceSort.maxTeilsumme1(seq);
		for(Integer n: mts1){
			cfs.neuerEintrag(n.toString());
		}		
	}

}