package cfranc.com;
import java.lang.Thread;

public class TempoThread extends Thread {
	
	int sleepTime_ms=60000/Console.bpm;
	 
	public void run() {
		java.awt.Toolkit.getDefaultToolkit().beep();
		try {
			Thread.sleep(sleepTime_ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

}
