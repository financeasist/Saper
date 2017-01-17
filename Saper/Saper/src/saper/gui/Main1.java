package saper.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import saper.Cell;
import saper.GeneratorBoard;
import saper.logics.Easy;
import saper.logics.GeneratorBoardImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * TODO: comment
 * 
 * @author Roman
 * @since 13.01.2017
 */
public class Main1 {
	private static final JPanel controlPanel = new JPanel();
	private static final JPanel controlPanelForMenu = new JPanel();
	private static final GuiBoard board = new GuiBoard();
	static JTextField jt_mines, jt_time;

	public static void main(String[] arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JFrame frame = new JFrame();
				frame.setTitle("Сапер");
				frame.getContentPane().setLayout(new BorderLayout());
				frame.setSize(218, 300);
				frame.getContentPane().add(controlPanelForMenu, BorderLayout.BEFORE_FIRST_LINE);
				controlPanelForMenu.add(new JTextField(3));
				frame.getContentPane().add(controlPanel, BorderLayout.PAGE_START);
				frame.getContentPane().add(board, BorderLayout.CENTER);
				board.setBorder(new EmptyBorder(100, 100, 100, 100));

				jt_mines = new JTextField(4);
				jt_mines.setFont(new Font("Tahoma", Font.PLAIN, 14));
				jt_time = new JTextField(4);
				jt_time.setFont(new Font("Tahoma", Font.PLAIN, 14));
				controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
				controlPanel.add(jt_mines);
				jt_mines.setBackground(Color.black);
				jt_time.setBackground(Color.black);
				final JButton generate = new JButton("");
				generate.setIcon(new ImageIcon("D:\\workspace\\Saper\\resources\\new game.gif"));
				generate.addActionListener(new GuiAction(new Easy(), board, new GeneratorBoardImpl()));
				controlPanel.add(generate);
				controlPanel.add(jt_time);

				centre(frame);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setVisible(true);
			}
		});
	}

	public static void centre(Window w) {
		Dimension us = w.getSize();
		Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
		int newX = (them.width - us.width) / 2;
		int newY = (them.height - us.height) / 2;
		w.setLocation(newX, newY);

	}
}
