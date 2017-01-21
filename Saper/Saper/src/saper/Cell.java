package saper;
/**
 * Describes Cell
 * 
 * @author User
 * @version 1.0 21.01.17
 */
public interface Cell<T> {

	boolean isBomb();

	boolean isSuggestEmpty();

	boolean isSuggestBomb();

	
	void suggestBomb();

	void suggestEmpty();

	/**
	 * draws cell. Takes class T for drawing, and bollean value - what exacly we
	 * need to draw a real value or customer's suggested value.
	 * 
	 * @param paint
	 * @param real
	 */
	void draw(T paint, boolean real);
}
