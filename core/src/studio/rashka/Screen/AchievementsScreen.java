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

public class AchievementsScreen extends State {

    private Stage stage;
    private Map<String, ImageButtonStyle> buttonStyles;
    private Map<String, ImageButton> buttons;
    private Label text;
    private StringBuilder str = new StringBuilder("Нажмите на иконку");

    public AchievementsScreen(final Game game) {
        super(game);

        stage = new Stage();

        buttonStyles = new HashMap<String, ImageButtonStyle>();
        buttons = new HashMap<String, ImageButton>();
        buttonStyles.put("Home", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("Home"), null, null, null, null, null));
        buttonStyles.put("NONE", new ImageButtonStyle(History.getTextures().getAtlasTextureSkin().getDrawable("NONE"), null, null, null, null, null));

        buttons.put("Home", new ImageButton(buttonStyles.get("Home")));
        buttons.put("Outlaw", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Slave", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Peasant", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Volunteer", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Feudal", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Prince", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("In", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("All", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("TrueOtvet", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Stability", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("Like", new ImageButton(buttonStyles.get("NONE")));
        buttons.put("AllAch", new ImageButton(buttonStyles.get("NONE")));

        if (History.getPreference().loadOutlaw() >= 40) History.getPreference().setOutlaw((byte)1);
        if (History.getPreference().loadSlave() >= 40) History.getPreference().setSlave((byte)1);
        if (History.getPreference().loadPeasant() >= 40) History.getPreference().setPeasant((byte)1);
        if (History.getPreference().loadVolunteer() >= 40) History.getPreference().setVolunteer((byte)1);
        if (History.getPreference().loadFeudal() >= 40) History.getPreference().setFeudal((byte)1);
        if (History.getPreference().loadPrince() >= 40) History.getPreference().setPrince((byte)1);
        if (History.getPreference().loadIn() >= 40) History.getPreference().setIn((byte)1);
        if (History.getPreference().loadAll() >= 40) History.getPreference().setAll((byte)1);
        if (History.getPreference().loadTrueOtvet() >= 80) History.getPreference().setTrueOtvet((byte)1);
        if (History.getPreference().loadTrueOtvet() < 80) History.getPreference().setTrueOtvet((byte)0);
        if (History.getPreference().loadStability() == 5) History.getPreference().setStability((byte)1);
        if (History.getPreference().loadLike() >= 1) History.getPreference().setLike((byte)1);
        History.getPreference().saveAllAch();

        buttons.get("Home").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
        buttons.get("Home").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
        buttons.get("Home").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Home").setSize(120 * History.getRatioMonitorW(), 120 * History.getRatioMonitorH());
                buttons.get("Home").setPosition((History.WIDTH / 2 - 60) * History.getRatioMonitorW(), 0);
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                buttons.get("Home").setSize(128 * History.getRatioMonitorW(), 128 * History.getRatioMonitorH());
                buttons.get("Home").setPosition((History.WIDTH / 2 - 64) * History.getRatioMonitorW(), 0);
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                game.set(new MenuScreen(game));
            }
        });

        buttons.get("Outlaw").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Outlaw").setPosition(64 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Outlaw").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadOutlaw() < 40) {
                    str = new StringBuilder("До изгнания осталось: ");
                    str.append(40 - History.getPreference().loadOutlaw());
                }
                else if (History.getPreference().loadOutlaw() >= 40) str = new StringBuilder("Изгой - жизь не справедливая штука");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Slave").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Slave").setPosition(416 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Slave").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadSlave() < 40) {
                    str = new StringBuilder("До рабства осталось: ");
                    str.append(40 - History.getPreference().loadSlave());
                }
                else if (History.getPreference().loadSlave() >= 40) str = new StringBuilder("Вы раб - не хозяин своей судьбы");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Peasant").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Peasant").setPosition(768 * History.getRatioMonitorW(), 1216 * History.getRatioMonitorH());
        buttons.get("Peasant").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadPeasant() < 40) {
                    str = new StringBuilder("До крестьянина осталось: ");
                    str.append(40 - History.getPreference().loadPeasant());
                }
                else if (History.getPreference().loadPeasant() >= 40) str = new StringBuilder("Крестьянин живет мирно и платит налоги");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Volunteer").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Volunteer").setPosition(64 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Volunteer").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadVolunteer() < 40) {
                    str = new StringBuilder("До поступления на службу осталось: ");
                    str.append(40 - History.getPreference().loadVolunteer());
                }
                else if (History.getPreference().loadVolunteer() >= 40) str = new StringBuilder("Каждый мечтал стать воином - ты Великий");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Feudal").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Feudal").setPosition(416 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Feudal").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadFeudal() < 40) {
                    str = new StringBuilder("До получения феодала осталось: ");
                    str.append(40 - History.getPreference().loadFeudal());
                }
                else if (History.getPreference().loadFeudal() >= 40) str = new StringBuilder("Феодал живет в роскоши в кругу слуг");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Prince").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Prince").setPosition(768 * History.getRatioMonitorW(), 896 * History.getRatioMonitorH());
        buttons.get("Prince").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadPrince() < 40) {
                    str = new StringBuilder("Хочу стать князем: ");
                    str.append(40 - History.getPreference().loadPrince());
                }
                else if (History.getPreference().loadPrince() >= 40) str = new StringBuilder("Вы могущественный князь всея Руси");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("In").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("In").setPosition(64 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("In").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadIn() < 40) {
                    str = new StringBuilder("Запускай и играй: ");
                    str.append(40 - History.getPreference().loadIn());
                }
                else if (History.getPreference().loadIn() >= 40) str = new StringBuilder("Сразу видно любителя поубивать время");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("All").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("All").setPosition(416 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("All").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadAll() < 40) {
                    str = new StringBuilder("Получай результаты: ");
                    str.append(40 - History.getPreference().loadAll());
                }
                else if (History.getPreference().loadAll() >= 40) str = new StringBuilder("Сразу видно любителя древней истории");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("TrueOtvet").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("TrueOtvet").setPosition(768 * History.getRatioMonitorW(), 576 * History.getRatioMonitorH());
        buttons.get("TrueOtvet").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadTrueOtvet() < 80) {
                    str = new StringBuilder("Нужно дать больше верных ответов");
                }
                else if (History.getPreference().loadTrueOtvet() >= 80) str = new StringBuilder("Да Вы, Сударь, историк");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("Stability").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Stability").setPosition(64 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Stability").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadStability() != 5) {
                    if (History.getPreference().loadStability() < 4) {
                        str = new StringBuilder("Заверши тест одинаково подряд: ");
                        str.append(4 - History.getPreference().loadStability());
                    } else if (History.getPreference().loadStability() >= 4) {
                        str = new StringBuilder("Стабильность - 4 подряд одиннаковых результата");
                        History.getPreference().saveStability(5);
                    }
                    stage.clear();
                    onRestart();
                } else {
                    str = new StringBuilder("Стабильность");
                    stage.clear();
                    onRestart();
                }
            }
        });

        buttons.get("Like").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Like").setPosition(416 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("Like").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadLike() < 1) {
                    str = new StringBuilder("Оцените приложение или оставьте отзыв");
                }
                else if (History.getPreference().loadLike() >= 1) str = new StringBuilder("Благодарствую за оценку/отзыв =)");
                stage.clear();
                onRestart();
            }
        });

        buttons.get("AllAch").setSize(256 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("AllAch").setPosition(768 * History.getRatioMonitorW(), 256 * History.getRatioMonitorH());
        buttons.get("AllAch").addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (History.getPreference().loadSound() == 1) History.getMusicSound().getClick().play();
                if (History.getPreference().loadAllAch() < 11) {
                    str = new StringBuilder("Нужно приложить больше усилий");
                }
                else if (History.getPreference().loadAllAch() == 11) str = new StringBuilder("Поистине великий подвиг");
                stage.clear();
                onRestart();
            }
        });

        onRestart();
    }

    private void onRestart() {
        text = new Label(str, new LabelStyle(History.getFontTTF().getFont(), Color.WHITE));
        text.setPosition(History.WIDTH / 2 * History.getRatioMonitorW() - text.getWidth() / 2, 165 * History.getRatioMonitorH());

        stage.addActor(text);
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Outlaw"));
        stage.addActor(buttons.get("Slave"));
        stage.addActor(buttons.get("Peasant"));
        stage.addActor(buttons.get("Volunteer"));
        stage.addActor(buttons.get("Feudal"));
        stage.addActor(buttons.get("Prince"));
        stage.addActor(buttons.get("In"));
        stage.addActor(buttons.get("All"));
        stage.addActor(buttons.get("TrueOtvet"));
        stage.addActor(buttons.get("Stability"));
        stage.addActor(buttons.get("Like"));
        stage.addActor(buttons.get("AllAch"));
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
        batch.draw(History.getTextures().textureRegions.get("black"), 10, 155, History.WIDTH - 20, 75);
        batch.draw(History.getTextures().textureEnd.get("outlaw"), 64, 1216, 256, 256);
        batch.draw(History.getTextures().textureEnd.get("slave"), 416, 1216, 256, 256);
        batch.draw(History.getTextures().textureEnd.get("peasant"), 768, 1216, 256, 256);
        batch.draw(History.getTextures().textureEnd.get("volunteer"), 64, 896, 256, 256);
        batch.draw(History.getTextures().textureEnd.get("feudal"), 416, 896, 256, 256);
        batch.draw(History.getTextures().textureEnd.get("prince"), 768, 896, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("In"), 64, 576, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("Done"), 416, 576, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("True"), 768, 576, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("Stability"), 64, 256, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("Like"), 416, 256, 256, 256);
        batch.draw(History.getTextures().textureRegions.get("All"), 768, 256, 256, 256);

        //region Outlaw
        if (History.getPreference().loadOutlaw() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadOutlaw() >= 10 && History.getPreference().loadOutlaw() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadOutlaw() >= 20 && History.getPreference().loadOutlaw() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 1216, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        else if (History.getPreference().loadOutlaw() >= 30 && History.getPreference().loadOutlaw() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 1280, 128, 128);
        }
        //endregion
        //region Slave
        if (History.getPreference().loadSlave() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadSlave() >= 10 && History.getPreference().loadSlave() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadSlave() >= 20 && History.getPreference().loadSlave() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 1216, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        else if (History.getPreference().loadSlave() >= 30 && History.getPreference().loadSlave() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 1280, 128, 128);
        }
        //endregion
        //region Preasant
        if (History.getPreference().loadPeasant() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 10 && History.getPreference().loadPeasant() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 20 && History.getPreference().loadPeasant() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 1216, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        else if (History.getPreference().loadPeasant() >= 30 && History.getPreference().loadPeasant() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 1344, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 1280, 128, 128);
        }
        //endregion
        //region Volunteer
        if (History.getPreference().loadVolunteer() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 896, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadVolunteer() >= 10 && History.getPreference().loadVolunteer() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 896, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadVolunteer() >= 20 && History.getPreference().loadVolunteer() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 896, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        else if (History.getPreference().loadVolunteer() >= 30 && History.getPreference().loadVolunteer() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 960, 128, 128);
        }
        //endregion
        //region Feudal
        if (History.getPreference().loadFeudal() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 896, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadFeudal() >= 10 && History.getPreference().loadFeudal() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 896, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadFeudal() >= 20 && History.getPreference().loadFeudal() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 896, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        else if (History.getPreference().loadFeudal() >= 30 && History.getPreference().loadFeudal() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 960, 128, 128);
        }
        //endregion
        //region Prince
        if (History.getPreference().loadPrince() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 896, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 10 && History.getPreference().loadPrince() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 896, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 20 && History.getPreference().loadPrince() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 896, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        else if (History.getPreference().loadPrince() >= 30 && History.getPreference().loadPrince() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 1024, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 960, 128, 128);
        }
        //endregion
        //region In
        if (History.getPreference().loadIn() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 576, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 10 && History.getPreference().loadIn() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 576, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 20 && History.getPreference().loadIn() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 576, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        else if (History.getPreference().loadIn() >= 30 && History.getPreference().loadIn() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 640, 128, 128);
        }
        //endregion
        //region All
        if (History.getPreference().loadAll() < 10) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 576, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 10 && History.getPreference().loadAll() < 20) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 576, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 20 && History.getPreference().loadAll() < 30) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 576, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        else if (History.getPreference().loadAll() >= 30 && History.getPreference().loadAll() < 40) {
            batch.draw(History.getTextures().textureRegions.get("black"), 544, 704, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 640, 128, 128);
        }
        //endregion
        //region TrueOtver
        if (History.getPreference().loadTrueOtvet() < 80) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 576, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 640, 128, 128);
        }
        //endregion
        //region Stability
        if (History.getPreference().loadStability() < 1) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 256, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 1) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 256, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 2) {
            batch.draw(History.getTextures().textureRegions.get("black"), 64, 256, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        else if (History.getPreference().loadStability() == 3) {
            batch.draw(History.getTextures().textureRegions.get("black"), 192, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 128, 320, 128, 128);
        }
        //endregion
        //region Like
        if (History.getPreference().loadLike() < 1) {
            batch.draw(History.getTextures().textureRegions.get("black"), 416, 256, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 480, 320, 128, 128);
        }
        //endregion
        //region AllAch
        if (History.getPreference().loadAllAch() < 1) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 256, 256, 256);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 1 && History.getPreference().loadAllAch() < 4) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 256, 256, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 4 && History.getPreference().loadAllAch() < 7) {
            batch.draw(History.getTextures().textureRegions.get("black"), 768, 256, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        else if (History.getPreference().loadAllAch() >= 7 && History.getPreference().loadAllAch() < 11) {
            batch.draw(History.getTextures().textureRegions.get("black"), 896, 384, 128, 128);
            batch.draw(History.getTextures().textureRegions.get("hide"), 832, 320, 128, 128);
        }
        //endregion
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            text.remove();
            buttonStyles.clear();
            buttons.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}