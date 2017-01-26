package saper.gui;

/**
 * Graphics cell. implements Cell<T>
 * 
 * @author Roman Grupskyi  
 * @version 1.3   21.01.2017
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import saper.Cell;

public class GuiCell implements Cell<Graphics> {
	private boolean bomb;
	private boolean suggestBomb = false;
	private boolean suggestEmpty = false;

	// Cell position into board array
	private int x;
	private int y;
	private String type;
	private BufferedImage img = null;

	public GuiCell(int x, int y, String type, boolean bomb) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.bomb = bomb;
	}

	@Override
	public boolean isBomb() {
		return this.bomb;
	}

	@Override
	public boolean isSuggestBomb() {
		return this.suggestBomb;
	}

	@Override
	public boolean isSuggestEmpty() {
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
	/**
	 * draws cell on board
	 * @param real - says what value needs to draw 
	 */
	@Override
	public void draw(Graphics paint, boolean real) {
		if (real) {
			if (this.bomb) {
				// draw bomb
				this.drawBomb(x, y, paint);
				if ("bang".equals(type))
					this.drawCellType(x, y, paint);
			} else {
				// draw real cell value
				this.drawCellType(x, y, paint);
			}
		} else {
			if (this.suggestBomb) {
				// draw flag
				this.drawFlag(x, y, paint);
			} else if (this.suggestEmpty) {
				// draw real cell value
				this.drawCellType(x, y, paint);
			} else {
				// draw closed cell
				String src = "resources/closed.gif";
				try {
					img = ImageIO.read(new File(src));
				} catch (IOException e) {
					e.printStackTrace();
				}
				paint.drawImage(img, this.x * 18 + 7, this.y * 18 + 7, 17, 17, null);

			}
		}
	}
	/**
	 * draws real cell value												
	 * @param x2
	 * @param y2
	 * @param paint
	 */
	private void drawCellType(int x, int y, Graphics paint) { 
		String src = "resources/" + type + ".gif";
		System.out.println(src);
		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paint.drawImage(img, x * 18 + 7, y * 18 + 7, 17, 17, null);
	}
	/**
	 * draws flag
	 * @param x
	 * @param y
	 * @param paint
	 */
	private void drawFlag(int x, int y, Graphics paint) {
		String src = "resources/flag.gif";
		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paint.drawImage(img, x * 18 + 7, y * 18 + 7, 17, 17, null);
	}
	/**
	 * draws bomb
	 * @param x
	 * @param y
	 * @param paint
	 */
	private void drawBomb(int x, int y, Graphics paint) {
		String src = "resources/bomb.gif";
		try {
			img = ImageIO.read(new File(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paint.drawImage(img, x * 18 + 7, y * 18 + 7, 17, 17, null);

	}

	public void setType(String type) {
		this.type = type;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	
}
