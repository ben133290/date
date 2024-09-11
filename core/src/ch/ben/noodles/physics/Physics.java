package ch.ben.noodles.physics;

import java.lang.Math;

public class Physics {

  private float gravity = -0.0f;
  private float xPos = 0;
  private float yPos = 0;
  private float xVel = 0;
  private float yVel = 0;
  private Direction facing;
  private float max_downward_vel = -0.1f;

  public Physics(float gravity, float xPos, float yPos) {
    this.gravity = gravity;
    this.xPos = xPos;
    this.yPos = yPos;
    this.facing = Direction.LEFT;
  }

  public void step() {

    // Cieling
    if (yPos > 11) {
      yVel = Math.min(0, yVel);
    }

    // Velocity
    if (yVel >= max_downward_vel) {
      yVel = yVel + gravity;
    }

    // Positions
    if (yPos > 0 || yPos == 0 && yVel > 0) {
      yPos = yPos + yVel;
    } else if (yPos <= 0) {
      yPos = 0;
      yVel = yVel - gravity;
    }
  }

  public void jump(float strength) {
    yVel = strength;
  }

  public Direction getFacing() {
    return facing;
  }

  public void setFacing(Direction facing) {
    this.facing = facing;
  }

  public float getxPos() {
    return xPos;
  }

  public float getyPos() {
    return yPos;
  }

  public float getyVel() {
    return yVel;
  }

  public float getxVel() {
    return xVel;
  }

  public boolean isIdle() {
    return xVel == 0;
  }

  public void setMoveSpeed(float move_speed) {
    this.xVel = move_speed;
  }
}
