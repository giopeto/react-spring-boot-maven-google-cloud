package configuration;

import com.googlecode.objectify.ObjectifyService;
import domain.Item;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ObjectifyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ObjectifyService.init();
		ObjectifyService.register(Item.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// App Engine does not currently invoke this method.
	}
}