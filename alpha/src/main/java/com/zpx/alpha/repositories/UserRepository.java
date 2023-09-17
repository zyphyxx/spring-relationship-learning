package com.zpx.alpha.repositories;

import com.zpx.alpha.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {

}
