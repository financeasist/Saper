package saper.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import saper.enums.Constants;
import saper.logics.Easy;
import saper.logics.GeneratorBoardImpl;

/**
 * Enterpoint to app. Creates Main FRAME
 * 
 * @author Roman
 * @since 13.01.2017
 */
public class Main {
	private static final GeneratorBoardImpl GENERATOR_EASY = new GeneratorBoardImpl() ;//Constants.COUNT_OF_BOMBS_EASY, Constants.BOARD_WIDTH_EASY, Constants.BOARD_HEIGHT_EASY
	//private static final GeneratorBoardImpl GENERATOR_MEDIUM = new GeneratorBoardImpl(Constants.COUNT_OF_BOMBS_MEDIUM, Constants.BOARD_WIDTH_MEDIUM, Constants.BOARD_HEIGHT_MEDIUM);
	private static final JPanel CONTROL_PANEL = new JPanel();
	private static final GuiBoard BOARD = new GuiBoard();
	private static final Easy LOGIC = new Easy();
	static JTextField jt_mines, jt_time;
	final static JFrame FRAME = new JFrame();

	public static void main(String[] arg) {

		FRAME.setTitle("Сапер");
		FRAME.getContentPane().setLayout(new BorderLayout());
		FRAME.setSize(212, 300);
		FRAME.getContentPane().add(CONTROL_PANEL, BorderLayout.PAGE_START);
		FRAME.getContentPane().add(BOARD, BorderLayout.CENTER);
		BOARD.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7),
				BorderFactory.createLoweredBevelBorder()));
		setmenu();
		jt_mines = new JTextField("push on");
		jt_mines.setFont(new Font("DigtalFont.TTF", Font.BOLD, 17));
		jt_mines.setForeground(Color.RED);
		jt_mines.setBorder(BorderFactory.createLoweredBevelBorder());
		jt_time = new JTextField(" smile!");
		jt_time.setFont(new Font("DigtalFont.TTF", Font.BOLD, 20));
		jt_time.setBorder(BorderFactory.createLoweredBevelBorder());
		jt_time.setForeground(Color.RED);
		jt_mines.setBackground(Color.black);
		jt_time.setBackground(Color.black);

		final JButton generate = new JButton("");
		generate.setIcon(new ImageIcon("resources\\new game.gif"));
		generate.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		generate.addActionListener(new GuiAction(LOGIC, BOARD, GENERATOR_EASY));

		CONTROL_PANEL.setLayout(new BoxLayout(CONTROL_PANEL, BoxLayout.X_AXIS));
		CONTROL_PANEL.add(jt_mines);
		CONTROL_PANEL.add(generate);
		CONTROL_PANEL.add(jt_time);

		centre(FRAME);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FRAME.setVisible(true);
	}

	public static void setmenu() {
		JMenuBar bar = new JMenuBar();
		JMenu game = new JMenu("GAME");
		JMenuItem menuitem = new JMenuItem("new game");
		final JCheckBoxMenuItem beginner = new JCheckBoxMenuItem("Begineer");
		final JCheckBoxMenuItem intermediate = new JCheckBoxMenuItem("Intermediate");
		final JCheckBoxMenuItem expart = new JCheckBoxMenuItem("Expart");
		final JCheckBoxMenuItem custom = new JCheckBoxMenuItem("Custom");
		final JMenuItem exit = new JMenuItem("Exit");
		final JMenu help = new JMenu("Help");
		final JMenuItem helpitem = new JMenuItem("Help");

		ButtonGroup status = new ButtonGroup();
		FRAME.setJMenuBar(bar);
		status.add(beginner);
		status.add(intermediate);
		status.add(expart);
		status.add(custom);

		game.add(menuitem);
		game.addSeparator();
		game.add(beginner);
		game.add(intermediate);
		game.add(expart);
		game.add(custom);
		game.addSeparator();
		game.add(exit);
		help.add(helpitem);

		bar.add(game);
		bar.add(help);

		menuitem.addActionListener(new GuiAction(LOGIC, BOARD, GENERATOR_EASY));
		//beginner.addActionListener(new GuiAction(LOGIC, BOARD, GENERATOR_EASY));

	
//	intermediate.addActionListener(new GuiAction(LOGIC, BOARD, GENERATOR_MEDIUM));
		custom.addActionListener(null);

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		helpitem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "instruction");

			}
		});

	}

	/**
	 * Placing specified as parameter window at the center of the screen
	 *
	 * @param w
	 *            centered window
	 */
	public static void centre(Window w) {
		Dimension us = w.getSize();
		Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
		// Coordinates top left corner for application window
		int newX = (them.width - us.width) / 2;
		int newY = (them.height - us.height) / 2;
		w.setLocation(newX, newY);

	}

	public static void setLabel(String textOnLabel) {
		jt_mines.setText(textOnLabel);
		jt_mines.repaint();
	}
}
