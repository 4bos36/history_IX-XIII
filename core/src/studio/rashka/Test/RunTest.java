package studio.rashka.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import studio.rashka.History;
import studio.rashka.Screen.MenuScreen;

public class RunTest {

    private boolean on1 = true, on50 = true, onTrue = true;

    private Stage stage, stageText;
    private Random random;
    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private Map<String, LabelStyle> labelStyles;
    private Map<String, Label> text;

    private static final int Q_ALL = 346; // -4
    private static final byte TEST = 20;
    private int Xq, Yq;
    private int Hq;
    private byte bugFix = 1;
    private boolean isShowTrue = false;

    private float RatioMonitorW, RatioMonitorH;

    public RunTest() {
        stage = new Stage();
        stageText = new Stage();
        random = new Random();

        text = new HashMap<String, Label>();
        labelStyles = new HashMap<String, LabelStyle>();
        labelStyles.put("Black", new LabelStyle(History.getFontTTF().getFont(), Color.BLACK));
        labelStyles.put("White", new LabelStyle(History.getFontTTF().getFont(), Color.WHITE));

        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();
        buttonStyles.put("Home", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"),null, null, null, null, null));
        buttonStyles.put("Repeat", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Repeat"),null, null, null, null, null));
        buttonStyles.put("Exit_small", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Exit_small"),null, null, null, null, null));
        buttonStyles.put("Continue", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Next"),null, null, null, null, null));
        buttonStyles.put("Feedback", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Feedback"),null, null, null, null, null));

        text.put("V1", new Label("", labelStyles.get("White")));
        text.put("V2", new Label("", labelStyles.get("White")));
        text.put("V3", new Label("", labelStyles.get("White")));
        text.put("V4", new Label("", labelStyles.get("White")));
        text.put("Help-1", new Label("", labelStyles.get("Black")));
        text.put("50/50", new Label("", labelStyles.get("Black")));
        text.put("True", new Label("", labelStyles.get("Black")));

        RatioMonitorW = (float) Gdx.graphics.getWidth() / (float) History.WIDTH;
        RatioMonitorH = (float) Gdx.graphics.getHeight() / (float) History.HEIGHT;
    }

    public void onStart() {
        onNomerTesta();

        //onTest(Q_ALL-1);
        onTest(random.nextInt(Q_ALL));
    }

    public void onTest(int i) {
        if (History.getTestChoice().equals("Test")) {
            if (History.getNomerTesta() > TEST) {
                onResult();
                return;
            } else History.getQuestions().onQuestion(i);
        }
        else if (History.getTestChoice().equals("Battle")) {
            if (History.getNomerTesta() > Q_ALL) {
                isShowTrue = true;
                showInfoTrue();
            }
            else History.getQuestions().onQuestion(i);
        }
    }

    public void onResult() {
        buttons.put("Repeat", new ImageButton(buttonStyles.get("Repeat")));
        buttons.put("Home", new ImageButton(buttonStyles.get("Home")));
        buttons.put("Exit_small", new ImageButton(buttonStyles.get("Exit_small")));
        buttons.put("Feedback", new ImageButton(buttonStyles.get("Feedback")));

        text.put("NameQuestion", new Label("* Результат *", labelStyles.get("Black")));
        if (History.getPravilno() >= 0 && History.getPravilno() <= 4) {
            text.put("V1", new Label("Вы - Изгой", labelStyles.get("Black")));
            text.put("V2", new Label("Когда-то Вы были уважаемым человеком,\nно однажды, сделав не верный шаг, Вы\nпотеряли все - деньги, имущество и власть.\nТеперь Вы изгой, отвергнутый близкими\nлюдьми.", labelStyles.get("White")));
            History.getPreference().saveOutlaw(1);
        }
        if (History.getPravilno() >= 5 && History.getPravilno() <= 9) {
            text.put("V1", new Label("Вы - Холоп", labelStyles.get("Black")));
            text.put("V2", new Label("Вы узник своей судьбы, не имеющий ни\nсвободы, ни своего слова. Вами помыкают\nлюди, в лучшем случае есть хозяин,\nкоторый выделяет какие-нибудь средства\nна более менее хорошую жизнь.", labelStyles.get("White")));
            History.getPreference().saveSlave(1);
        }
        if (History.getPravilno() >= 10 && History.getPravilno() <= 14) {
            text.put("V1", new Label("Вы - Крестьянин", labelStyles.get("Black")));
            text.put("V2", new Label("Благодаря своему трудолюбию у Вас есть\nнебольшое хозяйство, любящая семья и\nнебольшое жилище. Прикладывайте силы\nк своему делу и может быть получиться\nдостичь большего и, конечно, статуса.", labelStyles.get("White")));
            History.getPreference().savePeasant(1);
        }
        if (History.getPravilno() >= 15 && History.getPravilno() <= 17) {
            text.put("V1", new Label("Вы - Дружинник", labelStyles.get("Black")));
            text.put("V2", new Label("Вы храбрый, силен с твердым телом,\nкак сталь, не знающий поражений, а\nоружия и доспехи блестят, как новые.\nБез Вашего сопровождения ни один купец,\nфеодал и дажекнязь не выйдут к людям.", labelStyles.get("White")));
            History.getPreference().saveVolunteer(1);
        }
        if (History.getPravilno() >= 18 && History.getPravilno() <= 19) {
            text.put("V1", new Label("Вы - Феодал", labelStyles.get("Black")));
            text.put("V2", new Label("Вы высокопоставленный человек, которого\nуважают и боятся, как князя. Ведь Вы\nочень богаты, покупаете только лучшие\nтовары, да и таким имуществом не\nкаждый похвастается.", labelStyles.get("White")));
            History.getPreference().saveFeudal(1);
        }
        if (History.getPravilno() == 20) {
            text.put("V1", new Label("Вы - Князь", labelStyles.get("Black")));
            text.put("V2", new Label("Этого человека почитают и уважают все\nот нисших слоев населения до самых\nвысших. Ведь Вы что не на есть князь\nВсея Руси, у которого превышего всего\nблагосостояние своей страны и их людей.", labelStyles.get("White")));
            History.getPreference().savePrince(1);
        }

        History.getPreference().saveMin(History.getPravilno());
        History.getPreference().saveMax(History.getPravilno());
        History.getPreference().saveLast(History.getPravilno());
        History.getPreference().saveAll(1);
        History.getPreference().saveTrue(History.getPravilno());

        History.getAdHandler().toast(new StringBuilder().append("Верных ответов: ").append(History.getPravilno()).append(" из 20"));

        text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 - 85)) * History.getRatioMonitorH());
        text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (History.HEIGHT - (698 - 15)) * History.getRatioMonitorH());
        text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, 246 * History.getRatioMonitorH());

        buttons.get("Repeat").setSize(320 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Repeat").setPosition(0, 0);
        buttons.get("Repeat").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.setNomerTesta(1);
                History.setPravilno(0);
                History.getQuestions().onALL_1();
                onStageNewDelete();
                onTest(random.nextInt(Q_ALL));
            }
        });

        buttons.get("Home").setSize(192 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 192 / 2) * History.getRatioMonitorW(), 0);
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                History.getGame().set(new MenuScreen(History.getGame()));
                History.setNomerTesta(1);
                History.setPravilno(0);
                History.getQuestions().onALL_1();
                onStageNewDelete();
                //dispose();
            }
        });

        buttons.get("Exit_small").setSize(320 * History.getRatioMonitorW(), 192 * History.getRatioMonitorH());
        buttons.get("Exit_small").setPosition((History.WIDTH - 320) * History.getRatioMonitorW(), 0);
        buttons.get("Exit_small").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.app.exit();
            }
        });

        buttons.get("Feedback").setSize(256 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Feedback").setPosition((History.WIDTH / 2 - 128) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
        buttons.get("Feedback").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_IX_XIII");
                if (History.getPreference().loadLike() < 1) History.getPreference().saveLike(1);
            }
        });

        stage.addActor(text.get("NameQuestion"));
        stage.addActor(text.get("V1"));
        stage.addActor(text.get("V2"));

        stage.addActor(buttons.get("Repeat"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Exit_small"));
        stage.addActor(buttons.get("Feedback"));

        Gdx.input.setInputProcessor(stage);
    }

    public void showInfoTrue() {
        if (History.getTestChoice().equals("Test")) {
            text.put("NameQuestion", new Label("* Верный ответ *", labelStyles.get("Black")));
            text.put("V1", new Label(History.getQuestions().getV1(), labelStyles.get("Black")));
            text.put("V2", new Label(History.getQuestions().getV2(), labelStyles.get("White")));
            text.get("V2").setWidth((History.WIDTH - 65) * History.getRatioMonitorW());

            text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 - 85)) * History.getRatioMonitorH());
            text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (History.HEIGHT - (698 - 15)) * History.getRatioMonitorH());
            text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, 1110 * History.getRatioMonitorH() - text.get("V2").getPrefHeight());

            buttons.put("Continue", new ImageButton(buttonStyles.get("Continue")));
            buttons.get("Continue").setSize(192 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
            buttons.get("Continue").setPosition((History.WIDTH / 2 - 96) * History.getRatioMonitorW(), 0);
            buttons.get("Continue").addListener(new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    isShowTrue = false;
                    onStageNewDelete();
                    onTest(random.nextInt(Q_ALL));
                }
            });
        }
        else if (History.getTestChoice().equals("Battle")) {
            if (History.getPravilno() > History.getPreference().getBestBattle()) {
                History.getPreference().setBestBattle(History.getPravilno());
                History.getPreference().setVictory(1, true);
                History.getPreference().setDefeat(0, false);
                text.put("V2", new Label(new StringBuilder().append("Князе, эта битва была просто выдающейся! Даже самые стойкие вражеские войска не смогли противостоять храбрости и силе нашего полководца. Но это еще не конец! Впереди ждут новые битвы и победы!\n\n" +
                        "Твой результат: ").append(History.getPravilno()).append("\n" +
                        "Лучший результат: ").append(History.getPreference().getBestBattle()).append("\n" +
                        "Череда побед: ").append(History.getPreference().getVictory()).append("\n" +
                        "Череда поражений: ").append(History.getPreference().getDefeat()), labelStyles.get("White")));
            }
            else if (History.getPravilno() == History.getPreference().getBestBattle()) {
                text.put("V2", new Label(new StringBuilder().append("Шла долгая и тяжелая битва... Князе, наши ресурсы и силы уже на исходе, а противник не намерен сдаваться, хотя он так же уже обессилен. Пора идти на перемирие, но это не значит наше поражение!\n\n" +
                        "Твой результат: ").append(History.getPravilno()).append("\n" +
                        "Лучший результат: ").append(History.getPreference().getBestBattle()).append("\n" +
                        "Череда побед: ").append(History.getPreference().getVictory()).append("\n" +
                        "Череда поражений: ").append(History.getPreference().getDefeat()), labelStyles.get("White")));
            }
            else {
                History.getPreference().setVictory(0, false);
                History.getPreference().setDefeat(1, true);
                text.put("V2", new Label(new StringBuilder().append("Князе, твоя битва была долгой и великолепной, но, всему есть конец. Твои войска потерпели поражение и тебе больше не с кем идти дальше в бой. Ты отступаешь, но вскоре вернешься за победой!\n\n" +
                        "Твой результат: ").append(History.getPravilno()).append("\n" +
                        "Лучший результат: ").append(History.getPreference().getBestBattle()).append("\n" +
                        "Череда побед: ").append(History.getPreference().getVictory()).append("\n" +
                        "Череда поражений: ").append(History.getPreference().getDefeat()), labelStyles.get("White")));
            }
            text.put("NameQuestion", new Label("* Княжеская битва *", labelStyles.get("Black")));
            text.put("V1", new Label("окончена", labelStyles.get("Black")));
            text.get("V2").setWidth((History.WIDTH - 65) * History.getRatioMonitorW());
            text.get("V2").setWrap(true);

            text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 - 85)) * History.getRatioMonitorH());
            text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (History.HEIGHT - (698 - 15)) * History.getRatioMonitorH());
            text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, 620 * History.getRatioMonitorH());

            buttons.put("Continue", new ImageButton(buttonStyles.get("Home")));
            buttons.get("Continue").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
            buttons.get("Continue").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
            buttons.get("Continue").addListener(new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    buttons.get("Continue").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                    buttons.get("Continue").setPosition((History.WIDTH / 2 - 60) * History.getRatioMonitorW(), 0);
                    return true;
                }

                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    buttons.get("Continue").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                    buttons.get("Continue").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    isShowTrue = false;
                    History.getGame().set(new MenuScreen(History.getGame()));
                    History.setNomerTesta(1);
                    History.setPravilno(0);
                    History.getQuestions().onALL_1();
                    onStageNewDelete();
                }
            });

            buttons.put("Feedback", new ImageButton(buttonStyles.get("Feedback")));
            buttons.get("Feedback").setSize(256 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
            buttons.get("Feedback").setPosition((History.WIDTH / 2 - 128) * History.getRatioMonitorW(), (History.HEIGHT - 384) * History.getRatioMonitorH());
            buttons.get("Feedback").addListener(new InputListener() {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
                }

                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                    Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.history_IX_XIII");
                    if (History.getPreference().loadLike() < 1) History.getPreference().saveLike(1);
                }
            });
            stage.addActor(buttons.get("Feedback"));
        }

        stage.addActor(text.get("NameQuestion"));
        stage.addActor(text.get("V1"));
        stage.addActor(text.get("V2"));

        stage.addActor(buttons.get("Continue"));
        Gdx.input.setInputProcessor(stage);
    }

    public void onLabelText() {
        text.put("NameQuestion", new Label(History.getQuestions().getNameQuestion(), labelStyles.get("Black")));
        text.put("V1", new Label(History.getQuestions().getV1(), labelStyles.get("White")));
        text.put("V2", new Label(History.getQuestions().getV2(), labelStyles.get("White")));
        text.put("V3", new Label(History.getQuestions().getV3(), labelStyles.get("White")));
        text.put("V4", new Label(History.getQuestions().getV4(), labelStyles.get("White")));

        text.put("Help-1", new Label(new StringBuilder().append(History.getPreference().loadHelpRemove()), labelStyles.get("Black")));
        text.put("50/50", new Label(new StringBuilder().append(History.getPreference().loadHelp50()), labelStyles.get("Black")));
        text.put("True", new Label(new StringBuilder().append(History.getPreference().loadHelpTrue()), labelStyles.get("Black")));

        onLabelTextPosition();
    }

    public void newTextBonus() {
        text.put("Help-1", new Label(new StringBuilder().append(History.getPreference().loadHelpRemove()), labelStyles.get("Black")));
        text.put("50/50", new Label(new StringBuilder().append(History.getPreference().loadHelp50()), labelStyles.get("Black")));
        text.put("True", new Label(new StringBuilder().append(History.getPreference().loadHelpTrue()), labelStyles.get("Black")));
    }

    private void onLabelTextPosition() {
        if (bugFix == 0) {
            text.get("NameQuestion").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 + Yq - Xq)) * History.getRatioMonitorH());
            text.get("V1").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V1").getWidth() / 2, (830 + 36) * History.getRatioMonitorH());
            text.get("V2").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V2").getWidth() / 2, (638 + 36) * History.getRatioMonitorH());
            text.get("V3").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V3").getWidth() / 2, (446 + 36) * History.getRatioMonitorH());
            text.get("V4").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("V4").getWidth() / 2, (254 + 36) * History.getRatioMonitorH());

            text.get("Help-1").setPosition(320 * History.getRatioMonitorW() - text.get("Help-1").getWidth() / 2, (History.HEIGHT - 256) * History.getRatioMonitorH());
            text.get("50/50").setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.get("50/50").getWidth() / 2, (History.HEIGHT - 404) * History.getRatioMonitorH());
            text.get("True").setPosition((History.WIDTH - 320) * History.getRatioMonitorW() - text.get("True").getWidth() / 2, (History.HEIGHT - 256) * History.getRatioMonitorH());
        }
        else if (bugFix == 1) {
            text.get("NameQuestion").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("NameQuestion").getWidth() / 2, (History.HEIGHT - (698 + Yq - Xq)) * RatioMonitorH);
            text.get("V1").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V1").getWidth() / 2, (830 + 36) * RatioMonitorH);
            text.get("V2").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V2").getWidth() / 2, (638 + 36) * RatioMonitorH);
            text.get("V3").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V3").getWidth() / 2, (446 + 36) * RatioMonitorH);
            text.get("V4").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("V4").getWidth() / 2, (254 + 36) * RatioMonitorH);

            text.get("Help-1").setPosition(320 * RatioMonitorW - text.get("Help-1").getWidth() / 2, (History.HEIGHT - 256) * RatioMonitorH);
            text.get("50/50").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("50/50").getWidth() / 2, (History.HEIGHT - 404) * RatioMonitorH);
            text.get("True").setPosition((History.WIDTH - 320) * RatioMonitorW - text.get("True").getWidth() / 2, (History.HEIGHT - 256) * RatioMonitorH);
            bugFix = 0;
        }
    }

    public void repeatText() {
        onLabelText();

        stageText.addActor(text.get("NameQuestion"));
        stageText.addActor(text.get("V1"));
        stageText.addActor(text.get("V2"));
        stageText.addActor(text.get("V3"));
        stageText.addActor(text.get("V4"));
        stageText.addActor(text.get("TestText"));

        stageText.addActor(text.get("Help-1"));
        stageText.addActor(text.get("50/50"));
        stageText.addActor(text.get("True"));
    }

    public void onAddActor() {
        onNomerTesta();
        onLabelText();

        stageText.addActor(text.get("NameQuestion"));
        stageText.addActor(text.get("V1"));
        stageText.addActor(text.get("V2"));
        stageText.addActor(text.get("V3"));
        stageText.addActor(text.get("V4"));
        stageText.addActor(text.get("TestText"));
        stageText.addActor(text.get("Help-1"));
        stageText.addActor(text.get("50/50"));
        stageText.addActor(text.get("True"));

        stage.addActor(History.getQuestions().getBtn_v1());
        stage.addActor(History.getQuestions().getBtn_v2());
        stage.addActor(History.getQuestions().getBtn_v3());
        stage.addActor(History.getQuestions().getBtn_v4());
        stage.addActor(History.getQuestions().getBtn_Remove());
        stage.addActor(History.getQuestions().getBtn_5050());
        stage.addActor(History.getQuestions().getBtn_True());
        stage.addActor(History.getQuestions().getBtn_Exit());

        Gdx.input.setInputProcessor(stage);
    }

    public void onNomerTesta() {
        if (History.getTestChoice().equals("Test")) {
            text.put("TestText", new Label(History.getNomerTesta() + " из " + TEST, labelStyles.get("Black")));
            text.get("TestText").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("TestText").getWidth() / 2, 32 * RatioMonitorH);
        }
        else if (History.getTestChoice().equals("Battle")) {
            text.put("TestText", new Label(String.valueOf(History.getNomerTesta()), labelStyles.get("Black")));
            text.get("TestText").setPosition(History.WIDTH / 2 * RatioMonitorW - text.get("TestText").getWidth() / 2, 32 * RatioMonitorH);
        }
    }

    public void onStageNewDelete() {
        try {
            stage.dispose();
            stageText.dispose();
        } catch (IllegalArgumentException e) {
            // может выскочить
        }
        stage = new Stage();
        stageText = new Stage();
    }

    public void onStageNewDeleteText() {
        try {
            stageText.dispose();
        } catch (IllegalArgumentException e) {
            // может выскочить
        }
        stageText = new Stage();
    }

    public Stage getStage() {
        return stage;
    }

    public Stage getStageText() {
        return stageText;
    }

    public void setXq(int xq) {
        Xq = xq;
    }

    public void setYq(int yq) {
        Yq = yq;
    }

    public void setHq(int hq) {
        Hq = hq;
    }

    public int getTest() {
        return TEST;
    }

    public int getYq() {
        return Yq;
    }

    public int getHq() {
        return Hq;
    }

    public int getQ_all() {
        return Q_ALL;
    }

    public boolean isOn1() {
        return on1;
    }

    public boolean isOn50() {
        return on50;
    }

    public boolean isOnTrue() {
        return onTrue;
    }

    public void setOn1(boolean on1) {
        this.on1 = on1;
    }

    public void setOn50(boolean on50) {
        this.on50 = on50;
    }

    public void setOnTrue(boolean onTrue) {
        this.onTrue = onTrue;
    }

    public boolean isShowTrue() {
        return isShowTrue;
    }

    public void setShowTrue(boolean showTrue) {
        isShowTrue = showTrue;
    }

    public void dispose() {
        /*stage.dispose();
        buttonStyles.clear();
        buttons.clear();
        labelStyles.clear();
        text.clear();*/
    }
}