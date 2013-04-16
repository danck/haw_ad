package aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class SequenceSort {
	
	public static List<Integer> maxTeilsumme3(final int[] folge){
		int zugriffe = 0;
		int laenge = folge.length;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int von = -1;
		int bis = -1;
		
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
		List<Integer> erg = new ArrayList<Integer>();
		erg.add(maxSum);
		erg.add(von);
		erg.add(bis);
		erg.add(0); //zeit
		erg.add(0); //zeit
		erg.add(zugriffe);
		return erg;
		
	}
	
	public static List<Integer> maxTeilsumme2(final int[] folge) {
		int zugriffe = 0;
		int mat_zugriffe = 0;
		int laenge = folge.length;
		int maxSum = Integer.MIN_VALUE;
		int von = -1;
		int bis = -1;
		int[][] mat = new int[laenge][laenge];

		// Teilsummen berechnen
		for (int i = 0; i < laenge; i++) {
			int sum = folge[i];
			for (int j = i; j < laenge; j++) {
				zugriffe++;
				sum += (i == j) ? 0 : folge[j];
				mat[i][j] = sum;
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

		List<Integer> erg = new ArrayList<Integer>();
		erg.add(maxSum);
		erg.add(von);
		erg.add(bis);
		erg.add(0); //zeit
		erg.add(0); //zeit
		erg.add(zugriffe);
		erg.add(mat_zugriffe);
		return erg;
	}
	
	public static int maxteilsummeRekursiv(final int[] folge){
		int laenge = folge.length;
		if(laenge == 1){return Math.max(folge[0], 0);}
		int haelfte = folge.length/2;
		int[] linkeHaelfte = new int[haelfte];
		int[] rechteHaelfte = (laenge%2) == 0 ? new int[haelfte] : new int[haelfte+1];
		for(int i=0; i<haelfte;i++){
			linkeHaelfte[i]	= folge[i];
		}
		for(int i=haelfte; i<laenge;i++){
			rechteHaelfte[i-haelfte] = folge[i];
		} 
		int rechtesRandMax = rechtesRandMax(linkeHaelfte);
		int linkesRandMax = linkesRandMax(rechteHaelfte);
		return Math.max(Math.max(maxteilsummeRekursiv(linkeHaelfte), maxteilsummeRekursiv(rechteHaelfte)),(rechtesRandMax+linkesRandMax));
	}
	
	public static int rechtesRandMax(int[] linkeHaelfte){
		int laenge = linkeHaelfte.length;
		int max = linkeHaelfte[laenge-1];
		int zwischen_sum = max;
		if(laenge == 1){return max;}
		for(int i = laenge-2; i>=0;i--){
			zwischen_sum = zwischen_sum + linkeHaelfte[i];
			max = Math.max(max, zwischen_sum);
		}
		return max;
	}
	
	public static int linkesRandMax(int[] rechteHaelfte){
		int laenge = rechteHaelfte.length;
		int max = rechteHaelfte[0];
		int zwischen_sum = max;
		for(int i = 1; i<laenge;i++){
			zwischen_sum = zwischen_sum + rechteHaelfte[i];
			max = Math.max(max, zwischen_sum);
		}
		return max;
	}
	
	public static List<Integer> maxTeilsumme1(final int[] folge) {
		int zugriffe = 0;
		int bisherMax = 0;
		int randMax = 0;
		int von = -1;
		int bis = -1;
		for (int i = 0; i < folge.length; i++) {
			zugriffe++;
			if(randMax+folge[i] < 0){
				von = i+1;
			}
			randMax = Math.max(0, randMax + folge[i]);
			bis = (randMax > bisherMax) ? i : bis;
			bisherMax = Math.max(bisherMax, randMax);
		};
		List<Integer> erg = new ArrayList<Integer>();
		erg.add(bisherMax);
		erg.add(von);
		erg.add(bis);
		erg.add(0); //zeit
		erg.add(0); //zeit
		erg.add(zugriffe);
		return erg;
	}
}