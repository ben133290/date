package ch.ben.noodles.objects;

import ch.ben.noodles.physics.Physics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PlayerDuck {

  public Texture idleTexture;
  public Texture flyingTexture;
  public Texture runTexture;
  public Texture walkTexture;
  public Rectangle duckRectangle;
  public Physics characterPhysics;

  public PlayerDuck() {

    // load textures
    idleTexture = new Texture(Gdx.files.internal("images/ducks-Brysia/mallard_male/duck_idle.png"));
    flyingTexture = new Texture(Gdx.files.internal("images/ducks-Brysia/mallard_male/duck_flying_1.png"));
    runTexture = new Texture(Gdx.files.internal("images/ducks-Brysia/mallard_male/duck_run.png"));
    walkTexture = new Texture(Gdx.files.internal("images/ducks-Brysia/mallard_male/duck_walk_1.png"));

    duckRectangle = new Rectangle();
    duckRectangle.x = 2;
    duckRectangle.y = 10;
    duckRectangle.width = 1;
    duckRectangle.height = 1;

    characterPhysics = new Physics(-0.01f, duckRectangle.x, duckRectangle.y);

  }

}
