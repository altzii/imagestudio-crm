package com.imagestudio.service.impl;

import com.imagestudio.form.SignupForm;
import com.imagestudio.model.Role;
import com.imagestudio.model.User;
import com.imagestudio.repository.UserRepository;
import com.imagestudio.service.RoleService;
import com.imagestudio.service.UserService;
import com.imagestudio.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alt on 07.04.17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User delete(long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User signupUser(SignupForm signupForm) {
        User user = new User();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setEmail(signupForm.getEmail());
        user.setFirstName(signupForm.getFirstName());
        user.setLastName(signupForm.getLastName());
        user.setEnabled(true);

        if (signupForm.getIsPasswordGenerate()) {
            user.setPassword(StringUtils.generateRandomPassword());
        } else {
            user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
        }

        ArrayList<Role> roles = new ArrayList<>();

        Role role = roleService.findByName(signupForm.getRole());
        Role roleUser = roleService.findByName("ROLE_USER");

        roles.add(roleUser);
        roles.add(role);

        user.setRoles(roles);

        return userRepository.save(user);
    }
}
