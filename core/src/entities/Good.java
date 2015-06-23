package entities;

import rain.MainGame;
import rain.TextureManager;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Good extends Entity {

	public Good(Vector2 pos, Vector2 direction) {
		super(TextureManager.GOOD, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if (pos.y <= -TextureManager.GOOD.getHeight()) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.GOOD.getWidth());
			pos.set(x, MainGame.HEIGHT);
		}
	}

}
