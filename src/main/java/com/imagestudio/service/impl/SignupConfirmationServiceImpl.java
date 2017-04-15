package com.imagestudio.service.impl;

import com.imagestudio.model.SignupConfirmation;
import com.imagestudio.repository.SignupConfirmationRepository;
import com.imagestudio.service.SignupConfirmationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alt on 15.04.17.
 */
@Service
public class SignupConfirmationServiceImpl implements SignupConfirmationService {
    @Resource
    public SignupConfirmationRepository signupConfirmationRepository;

    @Override
    public SignupConfirmation create(SignupConfirmation signupConfirmation) {
        return signupConfirmationRepository.save(signupConfirmation);
    }

    @Override
    public SignupConfirmation delete(SignupConfirmation signupConfirmation) {
        signupConfirmationRepository.delete(signupConfirmation);
        return signupConfirmation;
    }

    @Override
    public SignupConfirmation delete(long id) {
        SignupConfirmation signupConfirmation = signupConfirmationRepository.findOne(id);
        signupConfirmationRepository.delete(signupConfirmation);
        return signupConfirmation;
    }

    @Override
    public List<SignupConfirmation> findAll() {
        return signupConfirmationRepository.findAll();
    }

    @Override
    public SignupConfirmation update(SignupConfirmation signupConfirmation) {
        return signupConfirmationRepository.saveAndFlush(signupConfirmation);
    }

    @Override
    public SignupConfirmation findById(long id) {
        return signupConfirmationRepository.findOne(id);
    }

    @Override
    public SignupConfirmation findByCode(String code) {
        return signupConfirmationRepository.findByCode(code);
    }
}