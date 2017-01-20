package saper.console;

import saper.Board;
import saper.Cell;

/**
 * TODO: comment
 * 
 * @author Roman Grupskyi
 * @since 13.01.2017
 */
public class ConsoleBoard implements Board {
	private Cell[][] cells;

	public void drawBoard(Cell[][] cells) {
		this.cells = cells;
		this.redraw(false);
	}

	public void drawCell(int x, int y) {
		System.out.println("***** SELECT ******");
		this.redraw(false);
	}

	public void drawBang() {
		System.out.println("***** BANG ******");
		this.redraw(true);
	}

	public void drawCongratulate() {
		System.out.println("***** CONGRATULATE ******");
	}

	private void redraw(boolean real) {
		for (Cell[] row : cells) {
			for (Cell cell : row) {
				cell.drawCell(System.out, real);
			}
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public void drawCell(int x, int y, String type) {
		// TODO Auto-generated method stub
		
	}
}
