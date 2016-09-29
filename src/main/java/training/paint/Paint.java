package training.paint;
/**
 * 
 * @author brian
 *
 */
public final class Paint {

	private int red;
	private int blue;
	private int yellow;
	private int white;

	private PaintFinish finish;

	Paint(int red, int blue, int yellow, int white, PaintFinish finish) {
		this.red = red;
		this.blue = blue;
		this.yellow = yellow;
		this.finish = finish;
		this.white = white;

	}

	public int getRed() {
		return red;
	}

	public int getBlue() {
		return blue;
	}

	public int getYellow() {
		return yellow;
	}

	public PaintFinish getFinish() {
		return finish;
	}

	public int getWhite() {
		return white;
	}

}
