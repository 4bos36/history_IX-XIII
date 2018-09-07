package studio.rashka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.net.ssl.internal.www.protocol.https.Handler;

import studio.rashka.AdHandler;
import studio.rashka.History;

public class DesktopLauncher implements AdHandler {

	private static DesktopLauncher application;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		if (application == null) {
			application = new DesktopLauncher();
		}

		config.title = History.TITLE;
		config.width = History.WIDTH / 3;
		config.height = History.HEIGHT / 3;
		new LwjglApplication(new History(application), config);
	}

	@Override
	public void showAds(int show) {

	}

	@Override
	public void toast(final StringBuilder result) {

	}
}