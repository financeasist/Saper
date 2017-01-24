package saper.logics;

import java.util.Random;

import saper.Cell;
import saper.GeneratorBoard;
import saper.gui.GuiCell;

/**
 * Describes the board's generator, that creates an array of cells, based on
 * which the board will be drawn.
 * 
 * @author Roman Grupskyi
 * @version 1.3 21.01 2017
 *
 */
public class GeneratorBoardImpl implements GeneratorBoard {

	final static int COUNT_OF_BOBMBS = 10;
	final static int BOARD_WIDTH = 10;
	final static int BOARD_HEIGH = 10;
	Cell[][] cells = new Cell[BOARD_WIDTH][BOARD_HEIGH];
	Integer[][] cellsNumbers = new Integer[BOARD_WIDTH][BOARD_HEIGH];

	/**
	 * Method generates array of cells, based on which the board will be drawn.
	 */
	
	public Cell[][] generate() {
		
		// here we set Numbers to cellsNumbers array;
		setNumbersToCell();

		// here we create the board with GuiCells[][] by cellsNumbers[][]
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGH; y++) {
				if (cellsNumbers[x][y] == -1)
					cells[x][y] = new GuiCell(x, y, "bomb", true);
				else
					cells[x][y] = new GuiCell(x, y, cellsNumbers[x][y].toString(), false);
			}
		}
		return cells;
	}

	/**
	 * This method sets Numbers to cellsNumbers[][] ;
	 */
	public void setNumbersToCell() {

		// initializes board with empty cells values;
		for (int y = 0; y < BOARD_HEIGH; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				cellsNumbers[x][y] = 0;
			}
		}

		// inserts à bombs on board;
		setBomb();

		// here we calculates and sets a number to cell
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGH; y++) {
				calculateAndSetCellNumber();
			}
		}
	}

	/**
	 * method sets bombs on the board by chance, according to COUNT_OF_BOBMBS;
	 */
	public void setBomb() {
		Random random = new Random();

		for (int i = 0; i < COUNT_OF_BOBMBS; i++) {
			int randomX = random.nextInt(BOARD_WIDTH - 1);
			int randomY = random.nextInt(BOARD_HEIGH - 1);
			cellsNumbers[randomX][randomY] = -1;
		}
	}

	/**
	 * Method, calculates int value, that shows how many
	 * bombs are around cell and sets this value into this cell.
	 */
	public void calculateAndSetCellNumber() {
		int[] possibleX = { -1, -1, -1, 0, 1, 1, 1, 0 }; 			 // possible values x coordinate
		int[] possibleY = { -1, 0, 1, 1, 1, 0, -1, -1 }; 			 // possible values y coordinate
		 						  							
		for (int x = 0; x < BOARD_WIDTH; x++) {				
			for (int y = 0; y < BOARD_HEIGH; y++) {				//here we run around all board, and checks
				int	cX, cY;	
				int value = 0;								// here value, we will need to set, resets fo each cell
				if (cellsNumbers[x][y] != -1) {				//if cell is not a bomb
					for (int k = 0; k < 8; k++) {			//we get all cells around this cell 
						cX = x + possibleX[k];				//(it always will be 8),
						cY = y + possibleY[k];
						if (cX >= 0 && cY >= 0 && cX < BOARD_WIDTH && cY < BOARD_HEIGH) { //and checks(is this cell within the borders of board)
							if (cellsNumbers[cX][cY] == -1) {							 //if cell is bomb,
								value++;											//than value increments
							}
						}

					}
					cellsNumbers[x][y] = value;						//sets this value 
				}
			}
		}
	}
}
