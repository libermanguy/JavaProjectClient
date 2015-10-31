package view;

import java.util.HashMap;

import general.Position;
import general.Solution;
import general.State;

//TODO: Auto-generated Javadoc
//TODO: Auto-generated Javadoc
/**
* 
*  * <h1>The Class MyView.</h1>
* Represents the view Interface layer in MVP architecture 
* <p>
*
* @author  Guy Liberman & Omri Polnikviat
* @version 1.0
* @since   2015-10-31
*/
public interface View {
	
	/**
	 * Display.
	 *
	 * @param arg the arg
	 */
	public void display(Object[] arg);
	
	/**
	 * Dir.
	 *
	 * @param path the path
	 */
	public void Dir(String path);
	
	/**
	 * Display maze.
	 *
	 * @param obj the obj
	 */
	public void displayMaze(Object[] obj);
	
	/**
	 * Display cross section.
	 *
	 * @param array the array
	 */
	public void displayCrossSection(Object[] array);
	
	/**
	 * Display maze size.
	 *
	 * @param size the size
	 */
	public void displayMazeSize(int size);
	
	/**
	 * Display file size.
	 *
	 * @param size the size
	 */
	public void displayFileSize(int size);
	
	/**
	 * Display solution.
	 *
	 * @param solution the solution
	 */
	public void displaySolution(Solution<Position> solution);
	
	/**
	 * Display str.
	 *
	 * @param arg the arg
	 */
	public void displayStr(String arg);

	/**
	 * Sets the cli.
	 *
	 * @param commands the commands
	 */
	public void setCLI(HashMap<String, Integer> commands);

	/**
	 * Display next step.
	 *
	 * @param state the state
	 */
	public void displayNextStep(State<Position> state);

	
}
