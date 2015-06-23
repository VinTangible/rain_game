package entities;

import rain.TextureManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {

	public Player(Vector2 pos, Vector2 direction) {
		super(TextureManager.PLAYER, pos, direction);
	}

	@Override
	public void update() {
		pos.add(direction);
		
		if (Gdx.input.isKeyPressed(Keys.A)) //left
			setDirection(-300, 0);
		else if (Gdx.input.isKeyPressed(Keys.D)) //right
			setDirection(300, 0);
		else 
			setDirection(0, 0);
	}
}
