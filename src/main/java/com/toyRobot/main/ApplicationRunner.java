package com.toyRobot.main;

import java.util.Scanner;

import com.toyRobot.controller.ToyRobotController;
import com.toyRobot.exception.InvalidInstructionException;
import com.toyRobot.exception.InvalidSurfaceException;
import com.toyRobot.exception.ToyRobotException;
import com.toyRobot.robot.MovableRobot;
import com.toyRobot.robot.RobotFactory;
import com.toyRobot.robot.RobotSurface;
import com.toyRobot.robot.SquareTableSurface;
import com.toyRobot.robot.ToyRobot;
/**
 * Main class for the toy robot project.
 *
 */
public class ApplicationRunner {

	public static void main(String[] args) {

		RobotSurface robotSurface = new SquareTableSurface(4, 4);
		MovableRobot robot = RobotFactory.getRobot("ToyRobot");
		ToyRobotController robotSimulator  = new ToyRobotController(robotSurface, robot);

		System.out.println("Rea Toy Robot Simulator");
		System.out.println("Enter an instruction, Valid instructions are:");
		System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");
		Scanner scanner = new Scanner(System.in);
		boolean keepRunning = true;
		while (keepRunning) {
			String inputString = scanner.nextLine();
			if ("EXIT".equals(inputString)) {
				keepRunning = false;
				System.out.println("Exiting ......");
			} else {
				try {
					robotSimulator.executeInstruction(inputString);
				} catch (InvalidSurfaceException | InvalidInstructionException | ToyRobotException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			}
		}
		scanner.close();
	}

}
