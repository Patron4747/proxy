package com.business.proxy.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author: mmustafin@context-it.ru
 * @created: 01.06.2020
 */
public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
