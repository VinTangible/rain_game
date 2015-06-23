package entities;

import rain.MainGame;
import rain.TextureManager;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Bad extends Entity {

	public Bad(Vector2 pos, Vector2 direction) {
		super(TextureManager.BAD, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if (pos.y <= -TextureManager.BAD.getHeight()) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.BAD.getWidth());
			pos.set(x, MainGame.HEIGHT);
		}
	}
}
