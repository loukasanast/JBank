package io.anastasiou;

public class UnauthorizedException extends Exception {
    public UnauthorizedException() {
        super("You are not authorized");
    }
}
