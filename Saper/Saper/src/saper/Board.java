package saper;

/**
 * Describes board behavior
 * 
 * @author Roman Grupkyi
 * @version 1.0 12.01.17
 *
 */
public interface Board {
	
	/**
	 * takes Cell[][] and draws Board.
	 * @param cells.
	 */

	void drawBoard(Cell[][] cells);
	
	/**
	 * draws cell.
	 * @param x
	 * @param y
	 */
	void drawCell(int x, int y);
	
	/**
	 * draws explosion.
	 */
	void drawBang(int x, int y);
	
	/**
	 * draws congratulations when game is won.
	 */
	void drawCongratulate();

}
