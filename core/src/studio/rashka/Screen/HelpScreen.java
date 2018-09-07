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

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class HelpScreen extends State {

    private Stage stage;

    private ImageButton btn_home;
    private Map<String, Label> text;

    public HelpScreen(final Game game) {
        super(game);

        stage = new Stage();
        text = new HashMap<String, Label>();

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

        text.put("help", new Label("На каждый вопрос дается 4 варианта\nответа, один из которых верный.\n\nТест имеет 20 вопросов, каждый из кото-\nрых появляется случайным образом и не\nповторяется.\n\nПосле прохождения всего теста, отобра-\nзится уникальная концовка, зависящая\nот того, сколько было дано правильных\nответов.", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.get("help").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("help").getWidth() / 2, (History.HEIGHT / 2 - 128) * History.getRatioMonitorH());

        text.put("Remove", new Label("Убирает один не верный вариант", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.put("5050", new Label("Убирает два не верных варианта", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.put("HelpTrue", new Label("Дает 8 из 10 случаев верный ответ", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK)));
        text.get("Remove").setPosition(185 * History.getRatioMonitorW(), (History.HEIGHT / 2 - 320) * History.getRatioMonitorH());
        text.get("5050").setPosition(185 * History.getRatioMonitorW(), (History.HEIGHT / 2 - 464) * History.getRatioMonitorH());
        text.get("HelpTrue").setPosition(185 * History.getRatioMonitorW(), (History.HEIGHT / 2 - 608) * History.getRatioMonitorH());

        stage.addActor(text.get("help"));
        stage.addActor(text.get("Remove"));
        stage.addActor(text.get("5050"));
        stage.addActor(text.get("HelpTrue"));
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
        batch.draw(History.getTextures().textureRegions.get("red"), 15, History.HEIGHT / 2 - 144, History.WIDTH - 30, 660);
        batch.draw(History.getTextures().textureRegions.get("green"), 15, 290, History.WIDTH - 30, 476);
        batch.draw(History.getTextures().textureRegions.get("Remove"), 30, History.HEIGHT / 2 - 352);
        batch.draw(History.getTextures().textureRegions.get("5050"), 30, History.HEIGHT / 2 - 496);
        batch.draw(History.getTextures().textureRegions.get("HelpTrue"), 30, History.HEIGHT / 2 - 640);
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