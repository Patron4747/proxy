package com.business.proxy.dto;

/**
 * @author: mmustafin@context-it.ru
 * @created: 01.06.2020
 */
public class AuthTokenDto {
    private String username;
    private String token;

    public AuthTokenDto() {
    }

    public AuthTokenDto(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
