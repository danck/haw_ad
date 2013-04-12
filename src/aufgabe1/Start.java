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
		
		System.out.println(seq);
	}

}
