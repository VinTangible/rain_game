package rain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
	public static Texture GOOD = new Texture(Gdx.files.internal("good.png"));
	public static Texture BAD = new Texture(Gdx.files.internal("bad.png"));
	public static Texture GAMEOVER = new Texture(Gdx.files.internal("gameover.png"));
}
