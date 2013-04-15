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
			for (int j = 0; j < laenge; j++) {
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
	}
}