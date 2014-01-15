package test;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main extends Thread {

	private static Tomcat tomcat;

	public static void main(String[] args) throws Exception {

		String webappDirLocation = "E:\\work\\test\\web-mvc\\src\\main\\webapp";
		tomcat = new Tomcat();

		// The port that we should run on can be set into an environment
		// variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		tomcat.setPort(Integer.valueOf(webPort));
		tomcat.enableNaming();
		Context context = tomcat.addWebapp("/web-mvc", new File(webappDirLocation).getAbsolutePath());
		context.setConfigFile(new File("context.xml").toURI().toURL());
		System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

		tomcat.start();
		Runtime.getRuntime().addShutdownHook(new Main());
		tomcat.getServer().await();
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Shutting down tomcat...");
			tomcat.destroy();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}

}
