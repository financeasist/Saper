package saper;

import saper.gui.Main;

/**
 * Implements UserAction
 * 
 * @author Grupskyi Roman
 * @version 1.1  21.01.2017
 */
public class BaseAction implements UserAction {

	private final GeneratorBoard generator;
	private final Board board;
	private final SaperLogic logic;

    
    /**
     * Constructs Base action
     * @param logic
     * @param board
     * @param generator
     */
	public BaseAction(SaperLogic logic, Board board, GeneratorBoard generator) {
		super();
		this.generator = generator;
		this.board = board;
		this.logic = logic;
	}
	
	@Override
	public void initGame() {
		Cell[][] cells = generator.generate();
		this.board.drawBoard(cells);
		this.logic.loadBoard(cells);
	}

    /**
     * {@inheritDoc}
     *
     * @param x coordinate x
     * @param y coordinate y
     * @param bomb mark for cell
     */
	@Override
	public void select(int x, int y, boolean bomb) {
		this.logic.suggest(x, y, bomb);
		board.drawCell(x, y);
		if (this.logic.shouldBang(x, y)) {
			board.drawBang(x,y);
			Main.setLabel("you lose!");
		}
		if (this.logic.finish()) {
			board.drawCongratulate();
			Main.setLabel("you win!");
		}
	}

}
