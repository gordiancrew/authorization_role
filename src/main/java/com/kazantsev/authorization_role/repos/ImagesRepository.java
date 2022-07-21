package com.kazantsev.authorization_role.repos;

import com.kazantsev.authorization_role.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Image, Integer> {
}
