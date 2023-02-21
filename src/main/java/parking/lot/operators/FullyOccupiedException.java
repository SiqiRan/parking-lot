package parking.lot.operators;

public class FullyOccupiedException extends RuntimeException {
    FullyOccupiedException(String message){
        super(message);
    }
}
