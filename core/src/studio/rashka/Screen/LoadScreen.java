package studio.rashka.Screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import studio.rashka.History;
import studio.rashka.Lib.Game;
import studio.rashka.Lib.State;

public class LoadScreen extends State {

    private static final int MAX = 80; // полная загрузка
    private byte i = 0; // индекс процесса загрузки

    private Stage stage;

    public LoadScreen(Game game) {
        super(game);
        stage = new Stage();
        History.getPreference().saveIn(1);

        History.getTextures().textureEnd.put("logo", new Texture("logo.png"));
        History.getTextures().textureEnd.put("name", new Texture("name.png"));
    }

    @Override
    public void update(float deltaTime) {
        i++;
        if (i == 20) History.getTextures().loadTextureEnd();
        if (i == MAX) game.set(new MenuScreen(game));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(History.getTextures().textureEnd.get("logo"), History.WIDTH / 2 - 224, History.HEIGHT - 512, 448, 300);
        batch.draw(History.getTextures().textureEnd.get("name"), History.WIDTH / 2 - 480, History.HEIGHT / 2 - 150, 960, 300);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
        } catch (NullPointerException e) {
            // на всякий случай
        }
    }
}