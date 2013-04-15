package aufgabe1;

public class SequenceSort {
	
	public static void maxteilsumme3(final int[] folge){
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
		
		System.out.println("Maxteilsummer ="+ maxSum + "\n"
				+"von " + von + " bis "+ bis + "\n"
				+ "Zugriffe: "+ zugriffe);
	}
	
	public static void maxteilsumme2(final int[] folge) {
		int zugriffe = 0;

		int laenge = folge.length;
		int maxSum = Integer.MIN_VALUE;
		int von = -1;
		int bis = -1;
		int[][] erg = new int[laenge][laenge];

		// Teilsummen berechnen
		for (int i = 0; i < laenge; i++) {
			int sum = folge[i];
			for (int j = i; j < laenge; j++) {
				zugriffe++;
				sum += (i == j) ? 0 : folge[j];
				erg[i][j] = sum;
			}
		}
		
		// Maximale Teilsumme berechnen
		for (int i = 0; i < laenge; i++) {
			for (int j = i; j < laenge; j++) {
				zugriffe++;
				if (maxSum < erg[i][j]){
					maxSum = erg[i][j];
					von = i;
					bis = j;
				}
			}
		}

		//Ausgabe
		for (int i = 0; i < laenge; i++) {
			for (int j = 0; j < laenge; j++) {
				System.out.print(erg[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("Zugriffe: " + zugriffe);
		System.out.println("Maximale Teilsumme: " + maxSum);
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
}