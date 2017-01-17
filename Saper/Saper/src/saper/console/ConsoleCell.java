package saper.console;

import java.io.PrintStream;

import saper.Cell;

/**
 * TODO: comment
 * 
 * @author parsentev
 * @since 08.04.2015
 */
public class ConsoleCell implements Cell<PrintStream> {
	private boolean bomb;
	private boolean suggestBomb = false;
	private boolean suggestEmpty = false;

	public ConsoleCell(boolean bomb) {
		this.bomb = bomb;
	}

	@Override
	public boolean isBomb() {
		return this.bomb;
	}

	@Override
	public boolean isGuessedBomb() {
		return this.suggestBomb;
	}

	@Override
	public boolean isGuessedEmpty() {
		return this.suggestEmpty;
	}

	@Override
	public void suggestEmpty() {
		this.suggestEmpty = true;
	}

	@Override
	public void suggestBomb() {
		this.suggestBomb = true;
	}

	@Override
	public void drawCell(PrintStream paint, boolean real) {
		if (real) {
			if (this.isBomb()) {
				paint.print("[*] ");
			} else {
				paint.print("[ ] ");
			}
		} else {
			if (this.suggestBomb) {
				paint.print("[?] ");
			} else if (this.suggestEmpty) {
				paint.print("[ ] ");
			} else {
				paint.print("[�] ");
			}
		}
	}
}