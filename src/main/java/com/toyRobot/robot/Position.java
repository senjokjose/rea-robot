package com.toyRobot.robot;

import com.toyRobot.exception.ToyRobotException;
/**
 * Position representation 
 *
 */
public class Position {
    int x;
    int y;
    Direction direction;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
    /**
     * Returns next position with respect to the direction and move
     * @return
     * @throws ToyRobotException
     */
    public Position getNextPosition() throws ToyRobotException {
        if (this.direction == null)
            throw new ToyRobotException("Invalid robot direction");

        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}
}