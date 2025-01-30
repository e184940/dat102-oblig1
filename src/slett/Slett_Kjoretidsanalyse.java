package slett;

public class Slett_Kjoretidsanalyse {

	public static void main(String[] args) {
		
		long t_1 = 10_000_000L;
		long t_2 = 100_000_000L;
		long t_3 = 1_000_000_000L;
		long t_4 = 10_000_000_000L;
		
		int antallTester = 10;
		
		testTid(t_1, antallTester);
		testTid(t_2, antallTester);
		testTid(t_3, antallTester);
		testTid(t_4, antallTester);

	}
	
	public static void testTid(long t, int antallTester) {
		int[] tider = new int[antallTester];
		int gjennomsnittTid = 0;
		
		for (int i = 0; i < antallTester; i++) {
			tider[i] = tid(t);
		}
		
		for (int i = 0; i < antallTester; i ++) {
			System.out.print(tider[i] + " ");
			gjennomsnittTid = gjennomsnittTid + tider[i];
		}
		gjennomsnittTid = gjennomsnittTid / antallTester;
		System.out.println();
		System.out.println("Gjennomsnitt tid for n = " + Long.toString(t) + ": " + gjennomsnittTid);
		gjennomsnittTid = 0;
		
	}
	
	public static int tid(long n) {
		long startTid;
		long sluttTid;
		int deltaTid;
		
		startTid = System.currentTimeMillis();
		
		long k = 0;
		for (long i = 1; i <= n; i++) {
			k = k + 5;
		}
		sluttTid = System.currentTimeMillis();
		deltaTid = (int)(sluttTid - startTid);
		
		return deltaTid;
	}
	
	public static void tid_feilet(long n) {
		
		long startTid;
		long sluttTid;
		long gjennomsnittTid = 0;
		
		int antallTester = 10;
		
		int index = 0;
		int[] testTabell = new int[antallTester];
		
		
		for (int j = 0; j < antallTester; j++) {
			startTid = System.currentTimeMillis();
			
			long k = 0;
			for (long i = 1; i <= n; i++) {
				k = k + 5;
			}
			
			sluttTid = System.currentTimeMillis();
			
			gjennomsnittTid = gjennomsnittTid + sluttTid - startTid;
			testTabell[index] = (int)(sluttTid - startTid);
			index++;
			
			startTid = 0;
			sluttTid = 0;
		}
		gjennomsnittTid = gjennomsnittTid / antallTester;
		
		System.out.println("Tid i ms for " + Long.toString(n) + ": " + gjennomsnittTid);
		for (int s : testTabell) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

}
