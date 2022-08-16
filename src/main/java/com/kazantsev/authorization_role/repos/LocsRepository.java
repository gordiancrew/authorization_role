package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.Loc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocsRepository extends JpaRepository<Loc,Integer> {
}
