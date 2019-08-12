package com.toyRobot.robot;

/**
 * Interface for the robot surface
 *
 */
public interface RobotSurface {

	/**
	 * Validate a given position.
	 * @param position
	 * @return
	 */
    public boolean isValidPosition(Position position);

}