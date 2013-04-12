package aufgabe1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriter {
	final static String delimiter = " "; // Trennzeichen der Knoten einer Kante

	private ReaderWriter(){};

	public static List<Integer> getSequence(String path) throws IOException{
		List<Integer> sequence= new ArrayList<Integer>();
		String temp = new String();
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "UTF-8");
		BufferedReader input = new BufferedReader(isr);
		
		temp = input.readLine();
		for (String s: temp.split(delimiter)){
			sequence.add(Integer.parseInt(s));
		}

		return sequence;
	}
}
