package main;

public class NumeroInvalidoException extends Exception {
	private String msg;

	public NumeroInvalidoException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
