package saper;

/**
 * Describes what user can to do.
 * @author Roman Grupskiy.
 * @version 1.0 12.01.17
 *
 */
public interface UserAction {
	
	/**
	 * inits the game
	 */
	void initGame();
	
	/**
	 * selects cell and guess is there bomb or not
	 * @param x
	 * @param y
	 * @param bomb
	 */
	void select(int x,int y, boolean bomb);

}
