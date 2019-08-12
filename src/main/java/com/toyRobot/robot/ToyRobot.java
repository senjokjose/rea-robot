package com.toyRobot.robot;


/**
 * Class representation of the toy robot
 *
 */
public class ToyRobot implements MovableRobot {

    private Position currentPosition;

    /**
     * Set robot position for a give value.
     * @param position
     * @return
     */
    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.currentPosition = position;
        return true;
    }
    /**
     * Returns the current position  of position
     * @return
     */
    public Position getPosition() {
        return this.currentPosition;
    }

    /**
     * Moves the robot one unit forward in the direction it is currently facing
     * @return true for successful move
     */
    public boolean move(Position newPosition) {
        if (newPosition == null)
            return false;

        this.currentPosition = newPosition;
        return true;
    }

    /**
     * Rotates the robot 90 degrees LEFT
     * @return true for successful rotation.
     */
    public boolean rotateLeft() {
        if (this.currentPosition.direction == null)
            return false;

        this.currentPosition.direction = this.currentPosition.direction.leftDirection();
        return true;
    }

    /**
     * Rotates the robot 90 degrees RIGHT
     * @return true for successful rotation
     */
    public boolean rotateRight() {
        if (this.currentPosition.direction == null)
            return false;

        this.currentPosition.direction = this.currentPosition.direction.rightDirection();
        return true;
    }

}