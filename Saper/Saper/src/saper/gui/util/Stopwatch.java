package saper.gui.util;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Stopwatch extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long startTime;
	// final static java.text.SimpleDateFormat timerFormat = new
	// java.text.SimpleDateFormat("mm : ss :SSS");
	// final JButton startStopButton= new JButton("Start/stop");
	Thread updater;
	boolean isRunning = false;
	long a = 0;
	Runnable displayUpdater = new Runnable() {

		public void run() {
			displayElapsedTime(a);
			a++;
		}
	};
	private JTextField tf_time;

	public void stop() {
		long elapsed = a;
		isRunning = false;
		try {
			updater.join();
		} catch (InterruptedException ie) {
		}
		displayElapsedTime(elapsed);
		a = 0;
	}

	private void displayElapsedTime(long elapsedTime) {


		if (elapsedTime >= 0 && elapsedTime < 9) {
			tf_time.setText("00" + elapsedTime);
		} else if (elapsedTime > 9 && elapsedTime < 99) {
			tf_time.setText("0" + elapsedTime);
		} else if (elapsedTime > 99 && elapsedTime < 999) {
			tf_time.setText("" + elapsedTime);
		}
	}

	public void run() {
		try {
			while (isRunning) {
				SwingUtilities.invokeAndWait(displayUpdater);
				Thread.sleep(1000);
			}
		} catch (java.lang.reflect.InvocationTargetException ite) {
			ite.printStackTrace(System.err);
		} catch (InterruptedException ie) {
		}
	}

	public void Start() {
		startTime = System.currentTimeMillis();
		isRunning = true;
		updater = new Thread(this);
		updater.start();
	}
}