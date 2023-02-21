package parking.lot.exceptions;

public class FullyOccupiedException extends RuntimeException {
    public FullyOccupiedException(String message){
        super(message);
    }
}
