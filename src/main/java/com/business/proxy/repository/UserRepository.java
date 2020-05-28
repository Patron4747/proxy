package com.business.proxy.repository;

import com.business.proxy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: mmustafin@context-it.ru
 * @created: 28.05.2020
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
