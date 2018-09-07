package studio.rashka.Screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class StartTestScreen extends State {

    public StartTestScreen(Game game) {
        super(game);

        History.setNomerTesta(1); // обнуляем параметры
        History.setPravilno(0);

        History.getRunTest().onStart();
    }

    @Override
    public void update(float deltaTime) {
        if (History.getPreference().loadBonus()) {
            History.getPreference().setBonus(false);
            History.getRunTest().onStageNewDeleteText();
            History.getRunTest().newTextBonus();
            History.getRunTest().repeatText();
        }
        if (History.getPreference().loadTimeRun() && !History.getRunTest().isShowTrue())
            if (History.getNomerTesta() <= History.getRunTest().getTest()) History.getTime().onTime();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(History.getTextures().textureEnd.get("fon"), 0, 0, History.WIDTH, History.HEIGHT);
        batch.draw(History.getTextures().textureRegions.get("black"), 0, History.HEIGHT - 200, History.WIDTH, 192);
        batch.draw(History.getTextures().textureEnd.get("name"), History.WIDTH / 2 - 310, History.HEIGHT - 200, 620, 192);
        if (!History.getRunTest().isShowTrue()) {
            if (History.getNomerTesta() <= History.getRunTest().getTest()) {
                batch.draw(History.getTextures().textureRegions.get("red"), 16, History.HEIGHT - (698 + History.getRunTest().getYq()), History.WIDTH - 32, 160 + History.getRunTest().getHq());
                batch.draw(History.getTextures().textureRegions.get("green"), History.WIDTH / 2 - 56, 1000, 112, 112);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 832, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 640, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 448, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("black"), History.WIDTH / 2 - 704 / 2, 256, 704, 128);
                batch.draw(History.getTextures().textureRegions.get("red"), History.WIDTH / 2 - 224 / 2, 0, 224, 104);
                if (History.getTestChoice().equals("Test")) {
                    batch.draw(History.getTextures().textureRegions.get("green"), 0, 0, (History.WIDTH / 20) * History.getNomerTesta(), 20);
                    batch.draw(History.getTextures().textureRegions.get("black"), 0, 20, (History.WIDTH / 20) * History.getNomerTesta(), 2);
                }
                else if (History.getTestChoice().equals("Battle")) {
                    batch.draw(History.getTextures().textureRegions.get("green"), 0, 0, History.WIDTH, 20);
                    batch.draw(History.getTextures().textureRegions.get("black"), 0, 20, History.WIDTH * History.getNomerTesta(), 2);
                }

                if (History.getPreference().loadHelpRemove() > 0 && History.getRunTest().isOn1())
                    batch.draw(History.getTextures().textureRegions.get("Remove"), 256, History.HEIGHT - 384);
                else if (History.getPreference().loadHelpRemove() > 0 && !History.getRunTest().isOn1())
                    batch.draw(History.getTextures().textureRegions.get("RemoveNO"), 256, History.HEIGHT - 384);
                else if (History.getPreference().loadHelpRemove() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("RemoveNO"), 256, History.HEIGHT - 384);
                    batch.draw(History.getTextures().textureRegions.get("Add"), 256, History.HEIGHT - 384);
                }
                if (History.getPreference().loadHelp50() > 0 && History.getRunTest().isOn50())
                    batch.draw(History.getTextures().textureRegions.get("5050"), History.WIDTH / 2 - 64, History.HEIGHT - 340);
                else if (History.getPreference().loadHelp50() > 0 && !History.getRunTest().isOn50())
                    batch.draw(History.getTextures().textureRegions.get("5050NO"), History.WIDTH / 2 - 64, History.HEIGHT - 340);
                else if (History.getPreference().loadHelp50() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("5050NO"), History.WIDTH / 2 - 64, History.HEIGHT - 340);
                    batch.draw(History.getTextures().textureRegions.get("Add"), History.WIDTH / 2 - 64, History.HEIGHT - 340);
                }
                if (History.getPreference().loadHelpTrue() > 0 && History.getRunTest().isOnTrue())
                    batch.draw(History.getTextures().textureRegions.get("HelpTrue"), History.WIDTH - 384, History.HEIGHT - 384);
                else if (History.getPreference().loadHelpTrue() > 0 && !History.getRunTest().isOnTrue())
                    batch.draw(History.getTextures().textureRegions.get("HelpTrueNO"), History.WIDTH - 384, History.HEIGHT - 384);
                else if (History.getPreference().loadHelpTrue() <= 0) {
                    batch.draw(History.getTextures().textureRegions.get("HelpTrueNO"), History.WIDTH - 384, History.HEIGHT - 384);
                    batch.draw(History.getTextures().textureRegions.get("Add"), History.WIDTH - 384, History.HEIGHT - 384);
                }
            } else if (History.getNomerTesta() > History.getRunTest().getTest()) {
                batch.draw(History.getTextures().textureRegions.get("red"), 16, History.HEIGHT - 698, History.WIDTH - 32, 160);
                batch.draw(History.getTextures().textureRegions.get("black"), 16, 224, History.WIDTH - 32, 320);
                if (History.getPravilno() >= 0 && History.getPravilno() <= 4)
                    batch.draw(History.getTextures().textureEnd.get("outlaw"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
                if (History.getPravilno() >= 5 && History.getPravilno() <= 9)
                    batch.draw(History.getTextures().textureEnd.get("slave"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
                if (History.getPravilno() >= 10 && History.getPravilno() <= 14)
                    batch.draw(History.getTextures().textureEnd.get("peasant"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
                if (History.getPravilno() >= 15 && History.getPravilno() <= 17)
                    batch.draw(History.getTextures().textureEnd.get("volunteer"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
                if (History.getPravilno() >= 18 && History.getPravilno() <= 19)
                    batch.draw(History.getTextures().textureEnd.get("feudal"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
                if (History.getPravilno() == 20)
                    batch.draw(History.getTextures().textureEnd.get("prince"), History.WIDTH / 2 - History.getTextures().textureEnd.get("outlaw").getWidth() / 2, 592);
            }
        }
        else if (History.getRunTest().isShowTrue()) {
            batch.draw(History.getTextures().textureRegions.get("red"), 16, History.HEIGHT - 698, History.WIDTH - 32, 160);
            batch.draw(History.getTextures().textureRegions.get("black"), 16, 190, History.WIDTH - 32, 930);
        }
        batch.end();

        if (!History.getRunTest().isShowTrue()) {
            History.getRunTest().getStageText().act();
            History.getRunTest().getStageText().draw();
        }

        History.getRunTest().getStage().act();
        History.getRunTest().getStage().draw();

        if (History.getNomerTesta() <= History.getRunTest().getTest() && !History.getRunTest().isShowTrue()) {
            History.getTime().getStage().act();
            History.getTime().getStage().draw();
        }
    }

    @Override
    public void dispose() {
        try {
            History.getRunTest().dispose();
            History.getQuestions().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}