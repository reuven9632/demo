package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String firstName);

    @Transactional
    @Modifying
    @Query("UPDATE User user SET user.enabled = TRUE WHERE user.username = ?1")
    int enableUser(String username);
}
