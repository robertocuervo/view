package ch.netstal.roberto.osgi.view;

import ch.netstal.roberto.osgi.api.Timable;

public class TimeView {
	private final Timable timer;
	private Thread runner;
	private boolean running;

	public TimeView(Timable timer) {
		this.timer = timer;
		running = true;
	}

	public void start() {
		runner = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (running) {
						System.out.println(timer.getCurrentTime());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
				}

			}
		});
		runner.setDaemon(true);
		runner.start();

	}
	
	public void stop() {
		running = false;
	}

}
