package io.anastasiou.util;

import io.anastasiou.UnauthorizedException;

import javax.naming.AuthenticationException;

@FunctionalInterface
public interface Authenticator {
    void login() throws UnauthorizedException;
}
