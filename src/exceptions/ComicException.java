package exceptions;

public class ComicException extends Exception {

    String msg;
    
    public ComicException(String msg) {
	this.msg = msg;
    }

    public String getMsg() {
	return msg;
    }
    
}
