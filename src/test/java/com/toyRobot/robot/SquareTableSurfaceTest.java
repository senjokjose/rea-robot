package com.toyRobot.robot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.toyRobot.robot.SquareTableSurface;
import com.toyRobot.robot.Direction;
import com.toyRobot.robot.RobotSurface;
import com.toyRobot.robot.Position;

public class SquareTableSurfaceTest {
	RobotSurface surface;
	
	@Test
	public void test() {
		surface = new SquareTableSurface(4, 4);
		Position p= new Position(0,0,Direction.EAST);
		assertTrue(surface.isValidPosition(p));
		
	}
	@Test
	public void test_invalid_position() {
		surface = new SquareTableSurface(4,4);
		Position p= new Position(5, 0, Direction.NORTH);
		assertFalse(surface.isValidPosition(p));
		
	}

}
