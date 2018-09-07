package studio.rashka.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class MenuScreen extends State {

    private Stage stage;
    private Map<String, ImageButton> buttons;

    private ImageButton btn_mus;
    private ImageButtonStyle btn_mus_style;

    public MenuScreen(final Game game) {
        super(game);

        stage = new Stage();
        buttons = new HashMap<String, ImageButton>();

        buttons.put("Start", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Start"), null, null, null, null, null)));
        buttons.put("Battle", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Battle"), null, null, null, null, null)));
        buttons.put("Stat", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Stat"), null, null, null, null, null)));
        buttons.put("Exit", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Exit"), null, null, null, null, null)));
        buttons.put("About", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("About"), null, null, null, null, null)));
        buttons.put("Help", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Help"), null, null, null, null, null)));
        buttons.put("Achievements", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Achievements"), null, null, null, null, null)));
        buttons.put("Facebook", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Facebook"), null, null, null, null, null)));
        buttons.put("VK", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("VK"), null, null, null, null, null)));
        buttons.put("Twitter", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Twitter"), null, null, null, null, null)));
        buttons.put("GooglePlus", new ImageButton(new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("GooglePlus"), null, null, null, null, null)));

        buttons.get("Start").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Start").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 5) * History.getRatioMonitorH());
        buttons.get("Start").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Start").setSize(660 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("Start").setPosition((History.WIDTH / 2 - 330) * History.getRatioMonitorW(), 870 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Start").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("Start").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 5) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setTestChoice("Test");
                game.set(new StartTestScreen(game));
            }
        });

        buttons.get("Battle").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Battle").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 7) * History.getRatioMonitorH());
        buttons.get("Battle").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Battle").setSize(660 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("Battle").setPosition((History.WIDTH / 2 - 330) * History.getRatioMonitorW(), 1126 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Battle").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("Battle").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 7) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setTestChoice("Battle");
                game.set(new StartTestScreen(game));
            }
        });

        buttons.get("Stat").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Stat").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 3) * History.getRatioMonitorH());
        buttons.get("Stat").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Stat").setSize(660 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("Stat").setPosition((History.WIDTH / 2 - 330) * History.getRatioMonitorW(), 614 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Stat").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("Stat").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128 * 3) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new StatScreen(game));
            }
        });

        buttons.get("Exit").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Exit").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128) * History.getRatioMonitorH());
        buttons.get("Exit").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Exit").setSize(660 * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                buttons.get("Exit").setPosition((History.WIDTH / 2 - 330) * History.getRatioMonitorW(), 358 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Exit").setSize(704 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
                buttons.get("Exit").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (224 + 128) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.app.exit();
            }
        });

        btn_mus_style = new ImageButton.ImageButtonStyle();
        if (History.getPreference().loadMusic() == 1) btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOn");
        if (History.getPreference().loadMusic() == 0) btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOff");
        btn_mus = new ImageButton(btn_mus_style);
        btn_mus.setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        btn_mus.setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
        btn_mus.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                btn_mus.setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                btn_mus.setPosition((History.WIDTH / 2 - 60) * History.getRatioMonitorW(), 0);
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                btn_mus.setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                btn_mus.setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                switch (History.getPreference().loadMusic()) {
                    case 0:
                        History.getPreference().saveMusic(1);
                        History.getPreference().saveSound(1);
                        btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOn");
                        History.setLoadMusic((byte)1);
                        break;
                    case 1:
                        History.getPreference().saveMusic(0);
                        History.getPreference().saveSound(0);
                        btn_mus_style.up = History.getTextures().getAtlasTextureSkin().getDrawable("MusOff");
                        History.setLoadMusic((byte)1);
                        break;
                }
            }
        });

        buttons.get("About").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("About").setPosition(0, 0);
        buttons.get("About").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("About").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("About").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new AboutScreen(game));
            }
        });

        buttons.get("Help").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Help").setPosition((History.WIDTH - 128) * History.getRatioMonitorW(), 0);
        buttons.get("Help").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Help").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("Help").setPosition((History.WIDTH - 120) * History.getRatioMonitorW(), 0);
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Help").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("Help").setPosition((History.WIDTH - 128) * History.getRatioMonitorW(), 0);
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new HelpScreen(game));
            }
        });

        buttons.get("Achievements").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Achievements").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 176 * History.getRatioMonitorH());
        buttons.get("Achievements").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Achievements").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("Achievements").setPosition((History.WIDTH / 2 - 60) * History.getRatioMonitorW(), 180 * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Achievements").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("Achievements").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 176 * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new AchievementsScreen(game));
            }
        });

        buttons.get("Facebook").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Facebook").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("Facebook").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Facebook").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("Facebook").setPosition((History.WIDTH / 2 - 348) * History.getRatioMonitorW(), (History.HEIGHT - 380) * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Facebook").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("Facebook").setPosition((History.WIDTH / 2 - 352) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://www.facebook.com/groups/rashka.studio");
            }
        });

        buttons.get("VK").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("VK").setPosition((History.WIDTH / 2 - 160) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("VK").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("VK").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("VK").setPosition((History.WIDTH / 2 - 156) * History.getRatioMonitorW(), (History.HEIGHT - 380) * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("VK").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("VK").setPosition((History.WIDTH / 2 - 160) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://vk.com/rashka.studio");
            }
        });

        buttons.get("Twitter").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Twitter").setPosition((History.WIDTH / 2 + 32) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("Twitter").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Twitter").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("Twitter").setPosition((History.WIDTH / 2 + 36) * History.getRatioMonitorW(), (History.HEIGHT - 380) * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Twitter").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("Twitter").setPosition((History.WIDTH / 2 + 32) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://twitter.com/rashka_studio");
            }
        });

        buttons.get("GooglePlus").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("GooglePlus").setPosition((History.WIDTH / 2 + 224) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("GooglePlus").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("GooglePlus").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("GooglePlus").setPosition((History.WIDTH / 2 + 228) * History.getRatioMonitorW(), (History.HEIGHT - 380) * History.getRatioMonitorH());
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("GooglePlus").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("GooglePlus").setPosition((History.WIDTH / 2 + 224) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://plus.google.com/communities/117036335723806113531");
            }
        });

        stage.addActor(buttons.get("Start"));
        stage.addActor(buttons.get("Battle"));
        stage.addActor(buttons.get("Stat"));
        stage.addActor(buttons.get("Exit"));
        stage.addActor(btn_mus);
        stage.addActor(buttons.get("About"));
        stage.addActor(buttons.get("Help"));
        stage.addActor(buttons.get("Achievements"));
        stage.addActor(buttons.get("Facebook"));
        stage.addActor(buttons.get("VK"));
        stage.addActor(buttons.get("Twitter"));
        stage.addActor(buttons.get("GooglePlus"));
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
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            buttons.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}