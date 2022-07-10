package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
