package aufgabe1;

import java.io.IOException;
import java.util.List;

public class Start {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		CSF cfs = new CSF();
		starte(-100,100,100,cfs);
		cfs.close();

	}
	
	public static void starte(int min, int max, int folgenlaenge, CSF cfs) throws IOException{
		
		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		folgenerzeuger.zufallsFolge(min, max, folgenlaenge);
		int[] seq = new int[folgenlaenge];
		seq = Reader.getSequence("./Files/folge.dat");
		
		cfs.neuerEintrag(Integer.toString(folgenlaenge));
		cfs.neuerEintrag("maxteilsumme3");
		List<Integer> mts3 = SequenceSort.maxteilsumme3(seq);
		for(Integer n: mts3){
			cfs.neuerEintrag(n.toString());
		}
		
		cfs.newLine();
		
		cfs.neuerEintrag(Integer.toString(folgenlaenge));
		cfs.neuerEintrag("maxteilsumme2");
		List<Integer> mts2 = SequenceSort.maxteilsumme2(seq);
		for(Integer n: mts2){
			cfs.neuerEintrag(n.toString());
		}
		
		//SequenceSort.maxteilsummeRekursiv(seq));
		
	}

}