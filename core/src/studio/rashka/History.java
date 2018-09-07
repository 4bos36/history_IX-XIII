package studio.rashka;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Map;
import java.util.TreeMap;

import studio.rashka.Lib.FontTTF;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.Language;
import studio.rashka.Lib.Monitor;
import studio.rashka.Lib.MusicSound;
import studio.rashka.Lib.Preference;
import studio.rashka.Lib.Time;
import studio.rashka.Screen.LoadScreen;
import studio.rashka.Lib.Textures;
import studio.rashka.Test.Questions;
import studio.rashka.Test.RunTest;

public class History extends ApplicationAdapter {

	public static int WIDTH = 1080;
	public static final int HEIGHT = 1920;
	public static final String TITLE = "Своя история: Русь IX-XIII вв.";

	public static AdHandler adHandler;
	public History(AdHandler adHandler) {
		this.adHandler = adHandler;
	}

	private SpriteBatch batch;
	private static Game game;

	private OrthographicCamera camera;
	private static Preference preference; // lib
	private static MusicSound musicSound;
	private static Language language;
	private static Textures textures;
	private static FontTTF fontTTF;
	private static Monitor monitor;
	private static Time time;
	private static RunTest runTest;
	private static Questions questions;

	private static float ratioMonitorW, ratioMonitorH;

	private static byte LoadMusic = 1;
	private static int NomerTesta, Pravilno;
	private static String testChoice;

	@Override
	public void create () {
		batch = new SpriteBatch();
		game = new Game();

		musicSound = new MusicSound(); // load lib
		preference = new Preference();
		textures = new Textures();
		fontTTF = new FontTTF();
		language = new Language();
		monitor = new Monitor();

		musicSound.MusicSound(); // load music file

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);

		ratioMonitorW = monitor.getRatioMonitorW();
		ratioMonitorH = monitor.getRatioMonitorH();

		runTest = new RunTest();
		questions = new Questions();
		time = new Time();

		Gdx.gl.glClearColor(0, 0, 0, 1); // делаем экран чёрным
		game.push(new LoadScreen(game));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined); // режим камеры

		game.update(Gdx.graphics.getDeltaTime()); // обновляет активный экран
		game.render(batch); // отрисовываем экран

		if (LoadMusic == 1) { // старт/стоп музыки
			if (preference.loadMusic() == 1) musicSound.StartFon();
			if (preference.loadMusic() == 0) musicSound.getMusic().pause();
			LoadMusic = 0;
		}
	}

	/***** Тест *****/

	public static void setNomerTesta(int nomerTesta) {
		NomerTesta = nomerTesta;
	}

	public static void setPravilno(int pravilno) {
		Pravilno = pravilno;
	}

	public static int getNomerTesta() {
		return NomerTesta;
	}

	public static int getPravilno() {
		return Pravilno;
	}

	/***** Вызов библиотек *****/

	public static Game getGame() {
		return game;
	}

	public static Preference getPreference() {
		return preference;
	}

	public static Language getLanguage() {
		return language;
	}

	public static Textures getTextures() {
		return textures;
	}

	public static FontTTF getFontTTF() {
		return fontTTF;
	}

	public static MusicSound getMusicSound() {
		return musicSound;
	}

	public static AdHandler getAdHandler() {
		return adHandler;
	}

	public static void setWIDTH(int WIDTH) {
		History.WIDTH = WIDTH;
	}

	public static Time getTime() {
		return time;
	}

	// коэффициенты для масштабирования разных экранов для масштабирования графики на экране
	public static float getRatioMonitorW() {
		return ratioMonitorW;
	}

	public static float getRatioMonitorH() {
		return ratioMonitorH;
	}

	public static RunTest getRunTest() {
		return runTest;
	}

	public static Questions getQuestions() {
		return questions;
	}

	public static void setTestChoice(String testChoice) {
		History.testChoice = testChoice;
	}

	public static String getTestChoice() {
		return testChoice;
	}

	/****************** ИЗМЕНЕНИЯ ПАРАМЕТРОВ ИГРЫ **********************/

	public static void setLoadMusic(byte loadMusic) {
		LoadMusic = loadMusic;
	}

	@Override
	public void resume() {
		if (preference.loadMusic() == 1) musicSound.StartFon();
	}

	@Override
	public void pause() {
		if(musicSound.getMusic().isPlaying()) musicSound.getMusic().pause();
	}

	@Override
	public void dispose () {
		batch.dispose();

		musicSound.dispose();
		textures.dispose();
		language.dispose();
		fontTTF.dispose();

		System.exit(0);
	}
}