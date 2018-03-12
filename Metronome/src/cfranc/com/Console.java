package cfranc.com;

import java.util.Scanner;

public class Console {
	
	public static int bpm = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Thread th = new TempoThread();
	
		while (sc.hasNext()) {
			System.out.println("Entrez bpm");
			bpm = sc.nextInt();
			th.start();
		}
		
	}

}
