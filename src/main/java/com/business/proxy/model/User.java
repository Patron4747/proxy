package com.business.proxy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */
@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2183145813218412318L;

    @NaturalId
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstNme;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @JsonIgnore
    private List<Role> roles = new ArrayList<>();
}
