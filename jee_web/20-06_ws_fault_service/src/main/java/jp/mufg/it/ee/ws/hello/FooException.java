package jp.mufg.it.ee.ws.hello;

public class FooException extends Exception {

    public FooException() {
        super();
    }

    public FooException(String message) {
        super(message);
    }

    public FooException(Throwable cause) {
        super(cause);
    }

    public FooException(String message, Throwable cause) {
        super(message, cause);
    }
}