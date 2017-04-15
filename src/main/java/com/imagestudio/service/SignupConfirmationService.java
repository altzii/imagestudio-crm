package com.imagestudio.service;

import com.imagestudio.model.SignupConfirmation;

import java.util.List;


/**
 * Created by alt on 15.04.17.
 */
public interface SignupConfirmationService {
    SignupConfirmation create(SignupConfirmation signupConfirmation);

    SignupConfirmation delete(SignupConfirmation signupConfirmation);

    SignupConfirmation delete(long id);

    List<SignupConfirmation> findAll();

    SignupConfirmation update(SignupConfirmation signupConfirmation);

    SignupConfirmation findById(long id);

    SignupConfirmation findByCode(String code);
}