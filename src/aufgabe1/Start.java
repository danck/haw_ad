package aufgabe1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> seq = new ArrayList<Integer>();
		try {
			seq = ReaderWriter.getSequence("./Files/folge.dat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int [] folge = new int[]{1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2, 1,2,3, -3, -10, 100, 2};
		int [] folge2 = new int[]{1, -2 ,3};

		SequenceSort.maxteilsumme2(folge);
		SequenceSort.maxteilsumme3(folge);
		System.out.print("\n"+SequenceSort.maxteilsummeRekursiv(folge));

		
		//System.out.println(seq);
	}

}