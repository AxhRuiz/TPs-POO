package main;

public class NoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 4L;

	public NoEncontradoException(String e) {
		super(e);
	}

}
