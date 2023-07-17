package sn.ssi.etontine.service;

public class TontineNotFoundException extends RuntimeException {
    public TontineNotFoundException(String message) {
        super(message);
    }
}
