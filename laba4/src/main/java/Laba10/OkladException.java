package Laba10;

public class OkladException extends Exception {
    public OkladException(String message) {
        super(message);
    }

    public OkladException(String message, double oklad) {
        super(message + ": " + oklad);
    }
}