package aufgabe1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FolgenErzeuger folgenerzeuger = new FolgenErzeuger();
		try {
			folgenerzeuger.zufallsFolge(-100, 100, 100);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Integer> seq = new ArrayList<Integer>();
		try {
			seq = ReaderWriter.getSequence("./Files/folge.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int [] folge = new int[]{1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2};
		int [] folge2 = new int[]{1, -2 ,3};

//		SequenceSort.maxteilsumme2(folge);
//		SequenceSort.maxteilsumme3(folge);
//		System.out.print("\n"+SequenceSort.maxteilsummeRekursiv(folge));

		
		//System.out.println(seq);
	}

}