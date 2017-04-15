package com.imagestudio.repository;

import com.imagestudio.model.SignupConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alt on 15.04.17.
 */
@Repository
public interface SignupConfirmationRepository extends JpaRepository<SignupConfirmation, Long> {
    SignupConfirmation findByCode(String code);
}