package com.toyRobot.controller;

import com.toyRobot.exception.InvalidInstructionException;
import com.toyRobot.exception.InvalidSurfaceException;
import com.toyRobot.exception.ToyRobotException;
import com.toyRobot.robot.RobotSurface;
import com.toyRobot.robot.Direction;
import com.toyRobot.robot.Position;
import com.toyRobot.robot.RobotInstruction;
import com.toyRobot.robot.MovableRobot;
/**
 * Toy robot controller class to interact with Toyrobot.
 * This class interprets the user instructions and delegate to the necessary classes.
 * It also take care of the initialization of the robot surface and toy robot.
 *
 */
public class ToyRobotController{
	private static final String DELIMITER_PRIMARY = " ";
	private static final String DELIMITER_SECONDARY = ",";


	RobotSurface surface;
	MovableRobot toyRobot;

	public ToyRobotController(RobotSurface grid,MovableRobot toyRobot) {
		this.surface = grid;
		this.toyRobot = toyRobot;
	}

	/**
	 * Execute a given instruction 
	 * @throws InvalidInstructionException 
	 * @throws InvalidSurfaceException 
	 */
	public boolean executeInstruction(String instructionString) throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {

		String[] args = instructionString.split(DELIMITER_PRIMARY);

		// validate the instruction
		RobotInstruction instruction;
		try {
			instruction = RobotInstruction.valueOf(args[0]);
		} catch (IllegalArgumentException e) {
			throw new ToyRobotException("Invalid instruction");
		}

		if(!validInstruction(instruction)) return false;

		switch (instruction) {
		case PLACE:
			Position position = constructRobotPosition(args);
			return placeToyRobot(position);
		case MOVE:
			Position newPosition = toyRobot.getPosition().getNextPosition();
			return toyRobot.move(newPosition);
		case LEFT:
			return toyRobot.rotateLeft();
		case RIGHT:
			return toyRobot.rotateRight();
		case REPORT:
			System.out.println(report());
			return true;
		default:
			throw new ToyRobotException("Invalid command");

		}

	}
	/**
	 * Place the robot position on a surface
	 * @param position
	 * @return
	 * @throws ToyRobotException
	 * @throws InvalidSurfaceException 
	 */
	private boolean placeToyRobot(Position position) throws ToyRobotException, InvalidSurfaceException {
		if (surface == null)
			throw new InvalidSurfaceException("Invalid surface object");

		if (position == null)
			throw new ToyRobotException("Invalid position object");

		if (position.getDirection() == null)
			throw new ToyRobotException("Invalid direction value");

		return surface.isValidPosition(position) ? toyRobot.setPosition(position) : false;
	}

	/**
	 * Validate robot instruction
	 * @param operation
	 * @return
	 * @throws ToyRobotException
	 * @throws InvalidSurfaceException 
	 * @throws InvalidInstructionException 
	 */
	private boolean validInstruction(RobotInstruction instruction) throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		if(instruction.equals(RobotInstruction.PLACE)) { // a special evaluation is doing laterSkipping validation for "PLACE" now, handling this at next level
			return true;
		}
		if(instruction == null) throw new InvalidInstructionException("Invalid robot instruction, null value");
		
		if(toyRobot == null) throw new ToyRobotException("No robot configured. Null value");
		
		if(surface == null) throw new InvalidSurfaceException("No robot surface configured. Null value");
		
		if(toyRobot.getPosition() == null) throw new ToyRobotException("No position configured for robot. Null value");
			
		if(toyRobot.getPosition().getDirection() == null) throw new ToyRobotException("No direction configured for robot. Null value");
			
		if(RobotInstruction.MOVE.equals(instruction) && !surface.isValidPosition(toyRobot.getPosition().getNextPosition()))
			throw new ToyRobotException("Invalid movement, position should fit limit (0,0) to "+surface.toString() );
		
		return true;
	}

	/**
	 * Construct position object from the arguments
	 * @param args
	 * @return
	 * @throws ToyRobotException
	 */
	private Position constructRobotPosition(String[] args) throws ToyRobotException {
		if(args.length < 2) {
			throw new ToyRobotException("Invalid command");
		}
		String[] params;
		int x = 0;
		int y = 0;
		Direction direction = null;
		params = args[1].split(DELIMITER_SECONDARY);
		try {
			x = Integer.parseInt(params[0]);
			y = Integer.parseInt(params[1]);
			direction = Direction.valueOf(params[2]);
			return new Position(x, y, direction);
		} catch (Exception e) {
			throw new ToyRobotException("Invalid instruction");
		}
	}
	/**
	 * Returns the X,Y and Direction of the robot
	 */
	public String report() {
		if (toyRobot.getPosition() == null) return null;
		return toyRobot.getPosition().getX() + "," + toyRobot.getPosition().getY() + "," + toyRobot.getPosition().getDirection().toString();
	}
}

