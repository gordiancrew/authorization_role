package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
