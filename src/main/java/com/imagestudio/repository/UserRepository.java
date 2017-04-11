package com.imagestudio.repository;

import com.imagestudio.model.Role;
import com.imagestudio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 07.04.17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE :role = some elements(u.roles)")
    List<User> findAllByRole( @Param("role") Role role);
}


