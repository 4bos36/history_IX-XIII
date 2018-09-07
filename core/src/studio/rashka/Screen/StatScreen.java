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

public class StatScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private ImageButton btn_home;

    public StatScreen(final Game game) {
        super(game);

        stage = new Stage();

        btn_home = new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null));
        btn_home.setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        btn_home.setPosition((History.WIDTH / 2 - 96)* History.getRatioMonitorW(), 0);
        btn_home.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                btn_home.setSize(180 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                btn_home.setPosition((History.WIDTH / 2 - 90)* History.getRatioMonitorW(), 0);
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                btn_home.setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                btn_home.setPosition((History.WIDTH / 2 - 96)* History.getRatioMonitorW(), 0);
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new MenuScreen(game));
            }
        });

        text = new HashMap<String, Label>();

        int min_ball = History.getPreference().loadMin();
        int test = History.getPreference().loadAll();
        int yes_all = test * 20;
        if (min_ball == 20) text.put("min", new Label("Худший тест: 0", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        if (min_ball != 20) text.put("min", new Label(new StringBuilder().append("Худший тест: ").append(min_ball), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));

        text.put("max", new Label(new StringBuilder().append("Лучший тест: ").append(History.getPreference().loadMax()), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.put("last", new Label(new StringBuilder().append("Последний тест: ").append(History.getPreference().loadLast()), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.put("all", new Label(new StringBuilder().append("Всего пройдено: ").append(test).append(" теста(ов)"), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.put("yes", new Label(new StringBuilder().append("Верных ответов: ").append(History.getPreference().loadTrue()).append(" из ").append(yes_all), new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));

        text.get("min").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("min").getWidth() / 2, 1088 * History.getRatioMonitorH());
        text.get("last").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("last").getWidth() / 2, (1088 - 64) * History.getRatioMonitorH());
        text.get("max").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("max").getWidth() / 2, (1088 - 128) * History.getRatioMonitorH());
        text.get("yes").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("yes").getWidth() / 2, (1088 - 192) * History.getRatioMonitorH());
        text.get("all").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("all").getWidth() / 2, (1088 - 256) * History.getRatioMonitorH());

        stage.addActor(text.get("min"));
        stage.addActor(text.get("last"));
        stage.addActor(text.get("max"));
        stage.addActor(text.get("yes"));
        stage.addActor(text.get("all"));
        stage.addActor(btn_home);

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
        batch.draw(History.getTextures().textureRegions.get("red"), History.WIDTH / 2 - 764 / 2, 800, 764, 368);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            btn_home.remove();
            text.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}