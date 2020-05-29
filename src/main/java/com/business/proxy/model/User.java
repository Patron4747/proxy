package com.business.proxy.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = -2183145813218412318L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NaturalId
    private String name;
    private String email;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
