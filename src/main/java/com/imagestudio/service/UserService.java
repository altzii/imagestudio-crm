package com.imagestudio.service;

import com.imagestudio.form.SignupForm;
import com.imagestudio.model.User;

import java.util.List;

/**
 * Created by alt on 07.04.17.
 */
public interface UserService {
    User create(User user);

    User delete(long id);

    List<User> findAll();

    User update(User user);

    User findById(long id);

    User findByEmail(String email);

    User signupUser(SignupForm signupForm);
}
