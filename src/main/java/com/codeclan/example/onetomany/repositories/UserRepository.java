package com.codeclan.example.onetomany.repositories;

import com.codeclan.example.onetomany.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
