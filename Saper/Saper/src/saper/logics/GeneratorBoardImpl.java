package saper.logics;

import java.util.Random;

import saper.Cell;
import saper.GeneratorBoard;
import saper.gui.GuiCell;

/**
 * Describes the board's generator, that creates an array of cells, based on
 * which, the board will be drawn.
 * 
 * @author Roman Grupskyi
 * @version 1.3 21.01 2017
 *
 */
public class GeneratorBoardImpl implements GeneratorBoard {

	private int countOfBombs = 3;
	private  int boardWidth = 3;
	private int boardHeight = 3;
	

	Cell[][] cells = new Cell[boardWidth][boardHeight];
	Integer[][] cellsNumbers = new Integer[boardWidth][boardHeight];
	Random random = new Random();
	
	
	

//	public GeneratorBoardImpl(int countOfBombs, int boardWidth, int boardHeight) {
//		this.boardWidth = boardWidth;
//		this.boardHeight = boardHeight;
//		this.countOfBombs = countOfBombs;
//	}

	/**
	 * Method generates array of cells, based on which the board will be drawn.
	 */
	
	@SuppressWarnings("rawtypes")
	public Cell[][] generate() {
		
		// here we set Numbers to cellsNumbers array;
		setNumbersToCell();

		// here we create the board with GuiCells[][] by cellsNumbers[][]
		for (int x = 0; x < boardWidth; x++) {
			for (int y = 0; y < boardHeight; y++) {
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
		for (int x = 0; x < boardWidth; x++) {
			for (int y = 0; y < boardHeight; y++) {
				cellsNumbers[x][y] = 0;
			}
		}

		// inserts à bombs on board;
		setBomb();

		// here we calculates and sets a number to cell
		for (int x = 0; x < boardWidth; x++) {
			for (int y = 0; y < boardHeight; y++) {
				calculateAndSetCellNumber();
			}
		}
	}

	/**
	 * method sets bombs on the board by chance, according to countOfBombs;
	 */
	public void setBomb() {
		int bombCount=0;
		int x = 0;
		int y = 0;
		while (bombCount<countOfBombs){
			int	randomX = random.nextInt(boardWidth - 1);
			int	randomY = random.nextInt(boardHeight - 1);
			if(randomX!=x||randomY!=y){
				x = randomX;
				y = randomY;
				cellsNumbers[x][y] = -1;
				bombCount++;
			}
		}
	}
		
	
	/**
	 * Method, calculates int value, that shows how many
	 * bombs are around cell and sets this value into this cell.
	 */
	public void calculateAndSetCellNumber() {
		int[] possibleX = { -1, -1, -1, 0, 1, 1, 1, 0 }; 			 // possible values x coordinate
		int[] possibleY = { -1, 0, 1, 1, 1, 0, -1, -1 }; 			 // possible values y coordinate
		 						  							
		for (int x = 0; x < boardWidth; x++) {				
			for (int y = 0; y < boardHeight; y++) {				//here we run around all board, and checks
				int	cX, cY;	
				int value = 0;								// here value, we will need to set, resets fo each cell
				if (cellsNumbers[x][y] != -1) {				//if cell is not a bomb
					for (int k = 0; k < 8; k++) {			//we get all cells around this cell 
						cX = x + possibleX[k];				//(it always will be 8),
						cY = y + possibleY[k];
						if (cX >= 0 && cY >= 0 && cX < boardWidth && cY < boardHeight) { //and checks(is this cell within the borders of board)
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
