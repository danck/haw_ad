package aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class SequenceSort {
	public static int maxteilsummeRekursivZugriffe = 0;
	public static long laufzeit = 0;
	public static int mat_zugriffe = 0;
	public static int von_rek;
	public static int bis_rek;
	
	public static List<Integer> maxTeilsumme3(final int[] folge){
		int zugriffe = 0;
		int laenge = folge.length;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int von = 0;
		int bis = 0;
		
		long start = System.nanoTime();
		for (int i = 0; i<laenge; i++){
			for (int j = (laenge - i); j>0; j-- ){
				sum = 0;
				for (int k = i; k<(i+j); k++ ){
					zugriffe++;
					sum += folge[k];
				}
				if (maxSum < sum){
					maxSum = sum;
					von = i;
					bis = j + i - 1;
					}
				}
		}
		long end = System.nanoTime();
		laufzeit = (end - start)/1000000;
		List<Integer> erg = new ArrayList<Integer>();
		erg.add(maxSum);
		erg.add(von);
		erg.add(bis);
		erg.add(zugriffe);
		return erg;
		
	}
	
	public static List<Integer> maxTeilsumme2(final int[] folge) {
		int zugriffe = 0;
		int laenge = folge.length;
		int maxSum = Integer.MIN_VALUE;
		int von = 0;
		int bis = 0;
		int[][] mat = new int[laenge][laenge];

		long start = System.nanoTime();
		// Teilsummen berechnen
		for (int i = 0; i < laenge; i++) {
			int sum = folge[i];
			zugriffe++;
			for (int j = i; j < laenge; j++) {
				zugriffe++;
				sum += (i == j) ? 0 : folge[j];
				mat[i][j] = sum;
				mat_zugriffe++;
			}
		}
		
		// Maximale Teilsumme berechnen
		for (int i = 0; i < laenge; i++) {
			for (int j = i; j < laenge; j++) {
				mat_zugriffe++;
				if (maxSum < mat[i][j]){
					maxSum = mat[i][j];
					von = i;
					bis = j;
				}
			}
		}
		long end = System.nanoTime();
		laufzeit = (end - start)/1000000;

		List<Integer> erg = new ArrayList<Integer>();
		erg.add(maxSum);
		erg.add(von);
		erg.add(bis);
		erg.add(zugriffe);
		return erg;
	}
	
	public static List<Integer> maxTeilsummeRekursiv(final int[] folge){
		long start = System.nanoTime();
		int[] ret = maxTeilsummeRekursiv_(folge);
		long end = System.nanoTime();
		laufzeit = (end - start)/1000000;
		List<Integer> erg = new ArrayList<Integer>();
		erg.add(ret[2]);
		erg.add(ret[0]);
		erg.add(ret[1]);
		return erg;
	}
	
	public static int[] maxTeilsummeRekursiv_(final int[] folge){
		int[] erg = new int[3];
		maxteilsummeRekursivZugriffe++;
		int laenge = folge.length;
		if(laenge == 1){
			erg[0] = folge[0];
			erg[1] = folge[0];
			erg[2] = Math.max(folge[0], 0);
			return erg;
		}
		int haelfte = folge.length/2;
		int[] linkeHaelfte = new int[haelfte];
		int[] rechteHaelfte = (laenge%2) == 0 ? new int[haelfte] : new int[haelfte+1];
		for(int i=0; i<haelfte;i++){
			maxteilsummeRekursivZugriffe++;
			linkeHaelfte[i]	= folge[i];
		}
		for(int i=haelfte; i<laenge;i++){
			maxteilsummeRekursivZugriffe++;
			rechteHaelfte[i-haelfte] = folge[i];
		} 
		int[] rechtesRandMax = rechtesRandMax(linkeHaelfte);
		int[] linkesRandMax = linkesRandMax(rechteHaelfte);
		int[] lHMax = maxTeilsummeRekursiv_(linkeHaelfte);
		int[] rHMax = maxTeilsummeRekursiv_(rechteHaelfte);
		int[] mitte = new int[3];
		mitte[0] = rechtesRandMax[1];
		mitte[1] = haelfte+linkesRandMax[1];
		mitte[2] = rechtesRandMax[2] + linkesRandMax[2];
		int max = Math.max(Math.max(lHMax[2], rHMax[2]),mitte[2]);
		if(max == lHMax[2]){
			erg[0] = lHMax[0];
			erg[1] = lHMax[1];
			erg[2] = lHMax[2];
		}
		if(max == rHMax[2]){
			erg[0] = rHMax[0]+haelfte;
			erg[1] = rHMax[1]+haelfte;
			erg[2] = rHMax[2]; 
		}
		if(max == mitte[2]){
			erg[0] = mitte[0];
			erg[1] = mitte[1];
			erg[2] = mitte[2];
		}
		return erg;
	}
	
	public static int[] rechtesRandMax(int[] linkeHaelfte){
		int[] erg = new int[3];
		int laenge = linkeHaelfte.length;
		int max = linkeHaelfte[laenge-1];
		int zwischen_sum = max;		
		erg[0] = laenge-1;
		erg[1] = laenge-1;
		erg[2] = max;
		if(laenge == 1){return erg;}
		for(int i = laenge-2; i>=0;i--){
			maxteilsummeRekursivZugriffe++;
			zwischen_sum = zwischen_sum + linkeHaelfte[i];
			if(zwischen_sum > max){
				max = zwischen_sum;
				erg[1] = i;
			}
		}
		erg[2] = max;
		return erg;
	}
	
	public static int[] linkesRandMax(int[] rechteHaelfte){
		int[] erg = new int[3];
		int laenge = rechteHaelfte.length;
		int max = rechteHaelfte[0];
		erg[0] = 0;
		erg[1] = 0;
		erg[2] = max;
		//if(laenge == 1){return erg;}
		int zwischen_sum = max;
		for(int i = 1; i<laenge;i++){
			maxteilsummeRekursivZugriffe++;
			zwischen_sum = zwischen_sum + rechteHaelfte[i];
			if(zwischen_sum > max){
				max = zwischen_sum;
				erg[1] = i;
			}
		}
		erg[2] = max;
		return erg;
	}
		
	public static List<Integer> maxTeilsumme1(final int[] folge) {
		int zugriffe = 0;
		int bisherMax = 0;
		int bisherMax_von = 0;
		int randMax = 0;
		int von = 0;
		int bis = 0;
		long start = System.nanoTime(); 
		for (int i = 0; i < folge.length; i++) {
			zugriffe++;
			if(randMax + folge[i] < 0){ 
				von = i+1;
			}
			randMax = Math.max(0, randMax + folge[i]);
			bisherMax_von = (randMax > bisherMax) ? von : bisherMax_von;
			bis = (randMax > bisherMax) ? i : bis;
			bisherMax = Math.max(bisherMax, randMax);
		};
		long end = System.nanoTime();
		laufzeit = (end - start)/1000000; 
		List<Integer> erg = new ArrayList<Integer>();
		erg.add(bisherMax);
		erg.add(bisherMax_von);
		erg.add(bis);
		erg.add(zugriffe);
		return erg;
	}
	
	public static void reset(){
		mat_zugriffe = 0;
	}
}