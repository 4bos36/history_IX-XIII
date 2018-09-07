package studio.rashka.Lib;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;

public class Textures {

    private TextureAtlas AtlasTexture;
    private Skin AtlasTextureSkin;

    private Texture atlas, achievements;
    public Map<String, TextureRegion> textureRegions; //массив регионов
    public Map<String, Texture> textureEnd;

    public Textures() {
        AtlasTexture = new TextureAtlas("buttons.texture");
        AtlasTextureSkin = new Skin(AtlasTexture);

        textureRegions = new HashMap<String, TextureRegion>();
        textureEnd = new HashMap<String, Texture>();
    }

    public void loadTextureEnd() {
        atlas = new Texture("btn.png");
        textureRegions.put("black", new TextureRegion(atlas, 0, 0, 64, 64));
        textureRegions.put("green", new TextureRegion(atlas, 0, 192, 64, 64));
        textureRegions.put("red", new TextureRegion(atlas, 0, 384, 64, 64));
        textureRegions.put("hide", new TextureRegion(atlas, 128, 960, 128, 128));

        textureRegions.put("Remove", new TextureRegion(atlas, 704, 0, 128, 128));
        textureRegions.put("5050", new TextureRegion(atlas, 832, 0, 128, 128));
        textureRegions.put("HelpTrue", new TextureRegion(atlas, 704, 128, 128, 128));
        textureRegions.put("Add", new TextureRegion(atlas, 832, 128, 128, 128));
        textureRegions.put("RemoveNO", new TextureRegion(atlas, 704, 256, 128, 128));
        textureRegions.put("5050NO", new TextureRegion(atlas, 832, 256, 128, 128));
        textureRegions.put("HelpTrueNO", new TextureRegion(atlas, 704, 384, 128, 128));

        achievements = new Texture("achievements.jpg");
        textureRegions.put("In", new TextureRegion(achievements, 0, 0, 256, 256));
        textureRegions.put("Done", new TextureRegion(achievements, 256, 0, 256, 256));
        textureRegions.put("True", new TextureRegion(achievements, 512, 0, 256, 256));
        textureRegions.put("Stability", new TextureRegion(achievements, 0, 256, 256, 256));
        textureRegions.put("Like", new TextureRegion(achievements, 256, 256, 256, 256));
        textureRegions.put("All", new TextureRegion(achievements, 512, 256, 256, 256));

        textureEnd.put("fon", new Texture("fon.jpg"));
        textureEnd.put("outlaw", new Texture("outlaw.jpg"));
        textureEnd.put("slave", new Texture("slave.jpg"));
        textureEnd.put("peasant", new Texture("peasant.jpg"));
        textureEnd.put("volunteer", new Texture("volunteer.jpg"));
        textureEnd.put("feudal", new Texture("feudal.jpg"));
        textureEnd.put("prince", new Texture("prince.jpg"));
    }

    public Skin getAtlasTextureSkin() {
        return AtlasTextureSkin;
    }

    public void dispose() {
        /*atlas.dispose();

        AtlasTexture.dispose();
        AtlasTextureSkin.dispose();
        textureRegions.clear();*/
    }
}