package com.toyRobot.robot;

/**
 * Interface for movable robot
 *
 */
public interface MovableRobot {

	public boolean setPosition(Position position);
	public Position getPosition();
	public boolean move(Position newPosition);
	public boolean rotateLeft();
	public boolean rotateRight();
}
