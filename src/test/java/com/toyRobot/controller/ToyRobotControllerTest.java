/**
 * 
 */
package com.toyRobot.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.toyRobot.exception.InvalidInstructionException;
import com.toyRobot.exception.InvalidSurfaceException;
import com.toyRobot.exception.ToyRobotException;
import com.toyRobot.robot.MovableRobot;
import com.toyRobot.robot.RobotFactory;
import com.toyRobot.robot.RobotSurface;
import com.toyRobot.robot.SquareTableSurface;


public class ToyRobotControllerTest {
	ToyRobotController toRobotController ;
	RobotSurface surface;
	MovableRobot toyRobot;

	@Before
	public void setUp() throws Exception {
		surface = new SquareTableSurface(4, 4);
		toyRobot = RobotFactory.getRobot("ToyRobot");
		toRobotController = new ToyRobotController(surface,toyRobot);
	}

	@Test
	public void test_place_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);

	}
	@Test
	public void test_move_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		assertTrue(toRobotController.report().equals("3,0,EAST"));

	}
	
	@Test
	public void test_rotate_left_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction("LEFT");
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		assertTrue(toRobotController.report().equals("0,2,NORTH"));

	}
	
	@Test
	public void test_rotate_right_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction("RIGHT");
		assertTrue(toRobotController.report().equals("2,0,SOUTH"));

	}
	
	@Test(expected = ToyRobotException.class)
	public void test_invalid_move_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);

	}
	
	@Test(expected = ToyRobotException.class)
	public void test_invalid_move2_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction("RIGHT");
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);

	}
	@Test(expected = InvalidSurfaceException.class)
	public void test_invalid_move3_robot() throws ToyRobotException, InvalidSurfaceException, InvalidInstructionException {
		toRobotController = new ToyRobotController(null,toyRobot);
		String instructions ="PLACE 0,0,EAST";
		toRobotController.executeInstruction(instructions);
		instructions ="MOVE";
		toRobotController.executeInstruction("RIGHT");
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);
		toRobotController.executeInstruction(instructions);

	}

}
