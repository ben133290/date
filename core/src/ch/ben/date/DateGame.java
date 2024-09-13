package ch.ben.date;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class DateGame extends ApplicationAdapter {

  // Render
  private OrthographicCamera camera;
  private SpriteBatch batch; // Used to render sprites like characters
  private ShapeRenderer shapeRenderer;
  private FitViewport viewport;
  private Stage stage;

  private BitmapFont font;

  @Override
  public void create() {

    // Graphics
    camera = new OrthographicCamera();
    viewport = new FitViewport(20, 12, camera);
    viewport.apply();
    batch = new SpriteBatch();
    shapeRenderer = new ShapeRenderer();

    // Text
    font = new BitmapFont();
    font.setUseIntegerPositions(false); // Apparently this needs to be set to false if the viewport has a small grid
                                        // size
    font.getData().setScale(.02f);

  }

  @Override
  public void render() {

    ScreenUtils.clear(0f, 0f, 0f, 0); // clears the screen and replaces with background color
    camera.update();

    // Draw shapes. The shapeRenderer has to be ended before batch can begin!
    shapeRenderer.setProjectionMatrix(camera.combined);
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(Color.DARK_GRAY);
    shapeRenderer.rect(1, 1, 18, 3);
    shapeRenderer.end();

    batch.setProjectionMatrix(camera.combined);
    batch.begin();

    font.draw(batch, "Hello World, it is nice meeting you!", 1, 4);
    batch.draw(new Texture(Gdx.files.internal("images/placeholder-avatar.jpg")), 13, 4, 5, 7);

    batch.end();

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
