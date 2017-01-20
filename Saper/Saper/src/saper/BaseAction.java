package saper;

/**
 * TODO: coments.
 * 
 * @author Grupskyi Roman
 * @version 1.0
 */
public class BaseAction implements UserAction {

	private final GeneratorBoard generator;
	private final Board board;
	private final SaperLogic logic;

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

	@Override
	public void select(int x, int y, boolean bomb) {
		this.logic.suggest(x, y, bomb);
		board.drawCell(x, y, null);
		if (this.logic.shouldBang(x, y)) {
			board.drawBang();
		}
		if (this.logic.finish()) {
			board.drawCongratulate();
		}
	}

}
