package ch.ben.noodles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import ch.ben.noodles.objects.LayeredBackground;
import ch.ben.noodles.objects.PlayerDuck;

public class NoodlesGame extends ApplicationAdapter {

  // Audio
  private Music rainMusic;

  // Render
  private OrthographicCamera camera;
  private SpriteBatch batch;
  private FitViewport viewport;

  // Player object
  private PlayerDuck playerDuck;
  private int spriteCounter = 0;
  private long spriteChanged = 0;

  // Background
  private LayeredBackground layeredBackground;
  private float backgroundXProg = 0;
  private float backgroundXProg2 = 0;

  @Override
  public void create() {

    // Audio
    rainMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/rain.mp3"));
    rainMusic.setLooping(true);
    rainMusic.play();

    // Graphics
    camera = new OrthographicCamera();
    viewport = new FitViewport(20, 12, camera);
    viewport.apply();
    batch = new SpriteBatch();

    playerDuck = new PlayerDuck();
    layeredBackground = new LayeredBackground();

    CharacterInputProcessor inputHandler = new CharacterInputProcessor(playerDuck.characterPhysics);
    Gdx.input.setInputProcessor(inputHandler);

    spriteCounter = 0;
    spriteChanged = System.currentTimeMillis();

  }

  @Override
  public void render() {
    ScreenUtils.clear(1f, 1f, 1f, 1);
    camera.update();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    // TextureRegion charTextureRegion = new TextureRegion(charImage,
    // spriteCounter*32, 0, 32, 32);

    // goes from 0 to -20
    backgroundXProg = backgroundXProg - 0.03f;
    if (backgroundXProg <= -20) {
      backgroundXProg = 0;
    }
    backgroundXProg2 = backgroundXProg2 - 0.06f;
    if (backgroundXProg2 <= -20) {
      backgroundXProg2 = 0;
    }
    batch.draw(layeredBackground.baseBackgroundLayer, 0, 0, 20, 12);
    batch.draw(layeredBackground.backMountainLayer, backgroundXProg, 0, 20, 12);
    batch.draw(layeredBackground.backMountainLayer, backgroundXProg + 20, 0, 20, 12);
    batch.draw(layeredBackground.midMountainLayer, backgroundXProg2, 0, 20, 12);
    batch.draw(layeredBackground.midMountainLayer, backgroundXProg2 + 20, 0, 20, 12);

    if (playerDuck.characterPhysics.getyPos() == 0) {
      batch.draw(playerDuck.runTexture,
          playerDuck.characterPhysics.getxPos(), playerDuck.characterPhysics.getyPos(),
          0, 0,
          2, 2,
          1, 1,
          0,
          (spriteCounter % 4) * 32, 0,
          32, 32,
          playerDuck.characterPhysics.getFacing().ordinal() == 0, false);
    } else {
      batch.draw(playerDuck.flyingTexture,
          playerDuck.characterPhysics.getxPos(), playerDuck.characterPhysics.getyPos(),
          0, 0,
          2, 2,
          1, 1,
          0,
          spriteCounter * 32, 0,
          32, 32,
          playerDuck.characterPhysics.getFacing().ordinal() == 0, false);
    }

    batch.draw(new Texture(Gdx.files.internal("images/ducks-Brysia/balloon-red.png")), 15, 6);

    batch.end();

    /*
     * if(Gdx.input.isTouched()) {
     * Vector3 touchPos = new Vector3();
     * touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
     * camera.unproject(touchPos);
     * bucket.x = touchPos.x - 64 / 2;
     * }
     */

    playerDuck.characterPhysics.step();
    if (System.currentTimeMillis() - spriteChanged > 100) {
      spriteCounter = (spriteCounter + 1) % 8;
      spriteChanged = System.currentTimeMillis();
      System.out.println(backgroundXProg);
    }
  }

  @Override
  public void dispose() {

  }

  @Override
  public void resize(int width, int height) {
    // use true here to center the camera
    // that's what you probably want in case of a UI
    viewport.update(width, height, true);
  }
}
