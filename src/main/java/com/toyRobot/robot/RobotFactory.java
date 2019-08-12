package com.toyRobot.robot;

/**
 * Factory class to get the Robot instance
 *
 */
public class RobotFactory {

	public static MovableRobot getRobot(String robotType){
		if(robotType.equals("ToyRobot")) {
			return new ToyRobot();
		}
		return null;
	}
}
