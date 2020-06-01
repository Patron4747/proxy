package com.business.proxy.dto;

import com.business.proxy.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author: mmustafin@context-it.ru
 * @created: 01.06.2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public User toUser() {
        User newUser = new User();
        newUser.setId(id);
        newUser.setName(name);
        newUser.setFirstNme(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);

        return newUser;
    }

    public static UserDto fromUser(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword() != null ? "<HIDDEN>" : "<EMPTY>");
        dto.setFirstName(user.getFirstNme());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        return dto;
    }
}
