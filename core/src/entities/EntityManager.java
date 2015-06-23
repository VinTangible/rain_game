package entities;

import rain.MainGame;
import rain.TextureManager;
import screens.GameOverScreen;
import screens.ScreenManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class EntityManager {
	private final Array<Entity> entities = new Array<Entity>();
	private final Player player;
	
	public EntityManager(int amount) {
		// Position of player is hard coded to the middle (TODO:should probably fix)
		player = new Player(new Vector2(230, 15), new Vector2(0, 0));
		
		for (int i = 0; i < amount; i++) {
			// Spawn bad entities
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.BAD.getWidth());
			float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 5);
			float speed = 5;
			addEntity(new Bad(new Vector2(x, y), new Vector2(0, -speed)));
			
			// Spawn good entities
			x = MathUtils.random(0, MainGame.WIDTH - TextureManager.GOOD.getWidth());
			y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 5);
			addEntity(new Good(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}
	
	public void update() {
		for (Entity e : entities)
			e.update();
		
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		for (Entity e : entities)
			e.render(sb);
		player.render(sb);
	}
	
	private void checkCollisions() {
		for (Entity e : getFallingEntities()) {
			if (e.getBounds().overlaps(player.getBounds())) {
				// Got hit so you lose
				if (e instanceof Bad){
					ScreenManager.setScreen(new GameOverScreen());
				}
				// Got something
				else{
					// Set it back to spawn at the top
					float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.GOOD.getWidth());
					float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
					e.pos.set(x, y);
				}
			}
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	private Array<Entity> getFallingEntities() {
		Array<Entity> ret = new Array<Entity>();
		for (Entity e : entities)
			if (e instanceof Bad || e instanceof Good)
				ret.add(e);
		return ret;
	}
}
