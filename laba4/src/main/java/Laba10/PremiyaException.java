package Laba10;

public class PremiyaException extends Exception {
    public PremiyaException(String message) {
        super(message);
    }

    public PremiyaException(String message, double premia) {
        super(message + ": " + premia);
    }
}