package view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

//TODO: Auto-generated Javadoc
/**
* 
*  * <h1>The Class MazeDisplayer.</h1>
* this is (1) the common type, and (2) a type of widget
* (1) we can switch among different MazeDisplayers
* (2) other programmers can use it naturally
* <p>
*
* @author  Guy Liberman & Omri Polnikviat
* @version 1.0
* @since   2015-10-31
*/


public abstract class MazeDisplayer extends Canvas{
	
	/** The maze data. */
	// just as a stub...
	int[][] mazeData={
			{0},
		};

	
	/**
	 * Instantiates a new maze displayer.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public MazeDisplayer(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Sets the maze data.
	 *
	 * @param mazeData the new maze data
	 */
	public void setMazeData(int[][] mazeData){
		this.mazeData=mazeData;
	}
	
	/**
	 * Sets the character position.
	 *
	 * @param row the row
	 * @param col the col
	 */
	public abstract  void setCharacterPosition(int row,int col);

	/**
	 * Sets the exit position.
	 *
	 * @param row the row
	 * @param col the col
	 */
	public abstract  void setExitPosition(int row,int col);
	
	/**
	 * Move up.
	 */
	public abstract void moveUp();

	/**
	 * Move down.
	 */
	public abstract  void moveDown();

	/**
	 * Move left.
	 */
	public abstract  void moveLeft();

	/**
	 * Move right.
	 */
	public  abstract void moveRight();

	/**
	 * Gets the character position.
	 *
	 * @return the character position
	 */
	public abstract int[] getCharacterPosition();
	
	/**
	 * Sets the character floor.
	 *
	 * @param floor the new character floor
	 */
	public abstract void setCharacterFloor(int floor);
	
	/**
	 * Sets the exit floor.
	 *
	 * @param floor the new exit floor
	 */
	public abstract void setExitFloor(int floor);
	
	/**
	 * Checks if is finished.
	 *
	 * @return true, if is finished
	 */
	public abstract boolean isFinished();
	
}