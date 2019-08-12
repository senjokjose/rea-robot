package com.toyRobot.robot;

/**
 * Square tabletop surface implementing RobotSurface
 *
 */
public class SquareTableSurface implements RobotSurface {

    int rows;
	int columns;
    
    
    public SquareTableSurface(int rows,int columns) {
		this.rows = rows;
		this.columns = columns;
	}

   
    /**
     * Check the given position is valid in  surface
     */
    public boolean isValidPosition(Position position) {
    	return !(
                position.getX() > this.columns || position.getX() < 0 ||
                        position.getY() > this.rows || position.getY() < 0
        );
    }


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "(" + rows + ", " + columns + ")";
	}

}