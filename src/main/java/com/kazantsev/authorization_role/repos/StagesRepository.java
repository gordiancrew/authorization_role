package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagesRepository extends JpaRepository<Stage, Integer> {
}
