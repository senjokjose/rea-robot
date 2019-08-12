package com.toyRobot.robot;

import java.util.HashMap;
import java.util.Map;
/**
 * Direction class representation
 *
 */
public enum Direction {

	    NORTH(0), EAST(1), SOUTH(2), WEST(3);
	    private static Map<Integer, Direction> directionMap = new HashMap<Integer, Direction>();

	    static {
	        for (Direction directionEnum : Direction.values()) {
	            directionMap.put(directionEnum.directionIndex, directionEnum);
	        }
	    }

	    private int directionIndex;

	    private Direction(int direction) {
	        this.directionIndex = direction;
	    }

	    public static Direction valueOf(int directionNum) {
	        return directionMap.get(directionNum);
	    }

	    /**
	     * Returns the left direction to the current one.
	     *  @return
	     */
	    public Direction leftDirection() {
	        return rotate(-1);
	    }

	    /**
	     * Returns the right direction to the current one
	     * @return
	     */
	    public Direction rightDirection() {
	        return rotate(1);
	    }

	    /**
	     * rotate the direction.
	     * @param step
	     * @return
	     */
	    private Direction rotate(int step) {

	        int newIndex = (this.directionIndex + step) < 0 ?
	                directionMap.size() - 1 :
	                (this.directionIndex + step) % directionMap.size();

	        return Direction.valueOf(newIndex);
	    }
}
