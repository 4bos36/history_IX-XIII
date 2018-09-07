package studio.rashka.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.StringBuilder;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class AboutScreen extends State {

    private Stage stage;
    private Map<String, ImageButton> buttons;
    private Map<String, Label> text;

    public AboutScreen(final Game game) {
        super(game);

        stage = new Stage();
        buttons = new HashMap<String, ImageButton>();
        buttons.put("Home", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null)));
        buttons.put("DownloadApp", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("DownloadApp"), null, null, null, null, null)));

        buttons.get("Home").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 96) * History.getRatioMonitorW(), 0);
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Home").setSize(180 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("Home").setPosition((History.WIDTH / 2 - 90) * History.getRatioMonitorW(), 0);
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Home").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("Home").setPosition((History.WIDTH / 2 - 96) * History.getRatioMonitorW(), 0);
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new MenuScreen(game));
            }
        });

        buttons.get("DownloadApp").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("DownloadApp").setPosition((History.WIDTH / 2 + 128) * History.getRatioMonitorW(), 320 * History.getRatioMonitorH());
        buttons.get("DownloadApp").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("DownloadApp").setSize(180 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("DownloadApp").setPosition((History.WIDTH / 2 + 134) * History.getRatioMonitorW(), 326 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("DownloadApp").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("DownloadApp").setPosition((History.WIDTH / 2 + 128) * History.getRatioMonitorW(), 320 * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_specific_rus");
            }
        });

        text = new HashMap<String, Label>();
        text.put("About", new Label("Разработчик: Табаков Юрий", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.put("Version", new Label(History.getLanguage().version, new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.put("app", new Label("Понравилось?\nСкачивай еще!", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));

        int x = History.getRunTest().getQ_all() - 1;
        text.put("ALL", new Label(new StringBuilder().append("Всего вопросов: ").append(x), new LabelStyle(History.getFontTTF().getFont(), Color.WHITE)));
        text.get("ALL").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("ALL").getWidth() / 2, 768 * History.getRatioMonitorH());

        text.get("About").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("About").getWidth() / 2, 832 * History.getRatioMonitorH());
        text.get("Version").setPosition(256 * History.getRatioMonitorW(), 704 * History.getRatioMonitorH());
        text.get("app").setPosition(240 * History.getRatioMonitorW(), 360 * History.getRatioMonitorH());

        stage.addActor(text.get("ALL"));
        stage.addActor(text.get("About"));
        stage.addActor(text.get("Version"));
        stage.addActor(text.get("app"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("DownloadApp"));

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(History.getTextures().textureEnd.get("fon"), 0, 0, History.WIDTH, History.HEIGHT);
        batch.draw(History.getTextures().textureRegions.get("black"), 0, History.HEIGHT - 200, History.WIDTH, 192);
        batch.draw(History.getTextures().textureEnd.get("name"), History.WIDTH / 2 - 310, History.HEIGHT - 200, 620, 192);
        batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 764 / 2, 672, 764, 496);
        batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 764 / 2, 300, 764, 230);
        batch.draw(History.getTextures().textureEnd.get("logo"), History.WIDTH / 2 - 192, 900, 384, 256);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            buttons.clear();
            text.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}