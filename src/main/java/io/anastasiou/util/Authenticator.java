package io.anastasiou.util;

import io.anastasiou.UnauthorizedException;

@FunctionalInterface
public interface Authenticator {
    void login() throws UnauthorizedException;
}
