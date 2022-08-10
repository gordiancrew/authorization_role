package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

//    @Modifying
//    @Query("UPDATE users  SET stage = stage +1 WHERE id = :id")
//    Integer plusStage( @Param("id") int id);

//    @Modifying
//    @Query("update users u set u.stage (select ) where u.id = ?1")
//    Integer plusStage(int id);

}
