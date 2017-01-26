package saper.logics;

import saper.Cell;
import saper.SaperLogic;
/**
 * Implements MinerLogic describing simple game logic
 * @author Roman Grupskyi
 * @version 1.2  21.01.2017
 *
 */
public class Easy implements SaperLogic {

	/**
     * Represents game board
     */
	private Cell[][] cells;
	
	/**
     * Initialises board representation
     *
     * @param cells cells of board
     */
	@Override
	public void loadBoard(Cell[][] cells) {
		this.cells = cells;

	}
	
	/**
     * Checks whether cell at coordinates should bangs or not
     *
     * @param x coordinate x
     * @param y coordinate y
     * @return <tt>true</tt> if must bang
     */
	@Override
	public Boolean shouldBang(int x, int y) {
		final Cell selected = this.cells[x][y];
		return selected.isBomb() && !selected.isSuggestBomb();
	}
	/**
     * Checks game was finished or not
     *
     * @return <tt>true</tt> if game was finished
     */
	@Override
	public Boolean finish() {
		boolean finish = false;
		for (Cell[] row : cells) {
			for (Cell cell : row) {
				finish = ((cell.isSuggestBomb() && cell.isBomb())
						|| (cell.isSuggestEmpty() && !cell.isBomb()));
			}
		}
		return finish;
	}
	/**
     * describes behavior when user suggest smth
     *
     * @param x coordinate x of cell
     * @param y coordinate y of cell
     * @param bomb mark of cell
     */
	@Override
	public void suggest(int x, int y, boolean bomb) {
		if (bomb) {
			this.cells[x][y].suggestBomb();
		} else {
			this.cells[x][y].suggestEmpty();
		}
	}

}
