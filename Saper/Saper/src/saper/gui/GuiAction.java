package saper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import saper.BaseAction;
import saper.GeneratorBoard;
import saper.SaperLogic;
import saper.logics.Easy;
/**
 * 
 * @author Roman Grupskyi
 * @version 1.2  21.01.2017
 *
 */
public class GuiAction extends BaseAction implements ActionListener, MouseListener {

	private GuiBoard board;
	/**
	 * Constructs Base action
	 * @param logic instance of logic
	 * @param board instance of board
	 * @param generator instance of board generator
	 */
	public GuiAction(SaperLogic logic, GuiBoard board, GeneratorBoard generator) {
		super(logic, board, generator);
		this.board = board;
		this.board.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.initGame();
	}

	public void mouseClicked(MouseEvent e) {
		int buttonId = e.getButton();
		int clickCount = e.getClickCount();
		int xc = e.getX();
		int yc = e.getY();

		this.select(xc/18, yc/18, buttonId !=1);
					
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
