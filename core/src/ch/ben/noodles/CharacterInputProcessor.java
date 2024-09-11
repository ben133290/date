package ch.ben.noodles;

import ch.ben.noodles.physics.Direction;
import ch.ben.noodles.physics.Physics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class CharacterInputProcessor implements InputProcessor {

  private final Physics physics;
  public final float WALKING_SPEED = 0.1f;
  public final float RUNNING_SPEED = 0.2f;
  private boolean isRunning;

  public CharacterInputProcessor(Physics physics) {
    this.physics = physics;
  }

  /**
   * Called when a key was pressed
   *
   * @param keycode one of the constants in {@link Input.Keys}
   * @return whether the input was processed
   */
  @Override
  public boolean keyDown(int keycode) {
    switch (keycode) {
      case Input.Keys.J:
        physics.jump(0.25f);
        return true;
    }
    return false;
  }

  /**
   * Called when a key was released
   *
   * @param keycode one of the constants in {@link Input.Keys}
   * @return whether the input was processed
   */
  @Override
  public boolean keyUp(int keycode) {
    switch (keycode) {
      case Input.Keys.J:
        return true;
    }
    return false;
  }

  /**
   * Called when a key was typed
   *
   * @param character The character
   * @return whether the input was processed
   */
  @Override
  public boolean keyTyped(char character) {
    return false;
  }

  /**
   * Called when the screen was touched or a mouse button was pressed. The button
   * parameter will be on iOS.
   *
   * @param screenX The x coordinate, origin is in the upper left corner
   * @param screenY The y coordinate, origin is in the upper left corner
   * @param pointer the pointer for the event.
   * @param button  the button
   * @return whether the input was processed
   */
  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  /**
   * Called when a finger was lifted or a mouse button was released. The button
   * parameter will be on iOS.
   *
   * @param screenX
   * @param screenY
   * @param pointer the pointer for the event.
   * @param button  the button
   * @return whether the input was processed
   */
  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  /**
   * Called when the touch gesture is cancelled. Reason may be from OS
   * interruption to touch becoming a large surface such as
   * the user cheek). Relevant on Android and iOS only. The button parameter will
   * be on iOS.
   *
   * @param screenX
   * @param screenY
   * @param pointer the pointer for the event.
   * @param button  the button
   * @return whether the input was processed
   */
  @Override
  public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  /**
   * Called when a finger or the mouse was dragged.
   *
   * @param screenX
   * @param screenY
   * @param pointer the pointer for the event.
   * @return whether the input was processed
   */
  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    return false;
  }

  /**
   * Called when the mouse was moved without any buttons being pressed. Will not
   * be called on iOS.
   *
   * @param screenX
   * @param screenY
   * @return whether the input was processed
   */
  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    return false;
  }

  /**
   * Called when the mouse wheel was scrolled. Will not be called on iOS.
   *
   * @param amountX the horizontal scroll amount, negative or positive depending
   *                on the direction the wheel was scrolled.
   * @param amountY the vertical scroll amount, negative or positive depending on
   *                the direction the wheel was scrolled.
   * @return whether the input was processed.
   */
  @Override
  public boolean scrolled(float amountX, float amountY) {
    return false;
  }
}
