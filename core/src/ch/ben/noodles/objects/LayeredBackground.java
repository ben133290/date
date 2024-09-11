package ch.ben.noodles.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class LayeredBackground {

  public Texture baseBackgroundLayer;
  public Texture backMountainLayer;
  public Texture midMountainLayer;

  public LayeredBackground() {

    baseBackgroundLayer = new Texture(Gdx.files.internal("images/background-blue.png"));
    backMountainLayer = new Texture(Gdx.files.internal("images/background-gray.png"));
    midMountainLayer = new Texture(Gdx.files.internal("images/background-darkgray.png"));
  }
}
