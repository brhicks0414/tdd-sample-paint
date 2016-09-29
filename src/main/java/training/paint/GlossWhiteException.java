package training.paint;

public class GlossWhiteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int badWhite;

	GlossWhiteException(int badWhite) {
		this.badWhite = badWhite;
	}

	public int badWhite() {
		return badWhite;
	}

}
