package com.toyRobot.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.toyRobot.controller.ToyRobotControllerTest;
import com.toyRobot.robot.SquareTableSurfaceTest;

@RunWith(Suite.class)
@SuiteClasses({ ToyRobotControllerTest.class,SquareTableSurfaceTest.class })
public class AllTests {

}
