package ch.netstal.roberto.osgi.view;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ch.netstal.roberto.osgi.api.Timable;

public class Activator implements BundleActivator {

	private ServiceReference<Timable> timerReference;

	private TimeView view;

	@Override
	public void start(BundleContext context) throws Exception {
		timerReference = context.getServiceReference(Timable.class);
		Timable timer = context.getService(timerReference);
		view = new TimeView(timer);
		view.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		view.stop();
		System.out.println("Timer Stopped");
	}
}
