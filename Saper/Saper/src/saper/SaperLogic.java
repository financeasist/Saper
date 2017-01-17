package saper;

public interface SaperLogic {

	/**
	 * downloads the field, which will take place computation.

	 * @param cells
	 */
	void loadBoard(Cell[][] cells);

	/**
	 * checks should cell bang or not
	 * @param x
	 * @param y
	 * @return true if there is a bomb and user don't guess it.
	 */
	Boolean shouldBang(int x, int y);

	/**
	 * checks is game over or not yet.
	 * @return true when all cells is opened/gessed.
	 */
	Boolean finish();

	/**
	 * here user clicks on cell and makes his suggest is bomb there or not
	 * @param x
	 * @param y
	 * @param bomb
	 */
	void suggest(int x, int y, boolean bomb);

}
