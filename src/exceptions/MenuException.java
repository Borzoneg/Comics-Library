package exceptions;

public class MenuException extends Exception{
    
    private int madeChoice;
    
    public MenuException(int madeChoice) {
	this.madeChoice = madeChoice;	
    }

}
