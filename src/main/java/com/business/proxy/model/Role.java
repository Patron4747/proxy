package com.business.proxy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: mmustafin@context-it.ru
 * @created: 29.05.2020
 */
@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;
}
