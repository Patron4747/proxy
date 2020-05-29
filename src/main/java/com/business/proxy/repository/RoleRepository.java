package com.business.proxy.repository;

import com.business.proxy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: mmustafin@context-it.ru
 * @created: 29.05.2020
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
