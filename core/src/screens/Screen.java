package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {
	public abstract void create();
	
	public abstract void update();
	
	public abstract void render(SpriteBatch sb);
	
	public abstract void resize(int width, int height);
}
