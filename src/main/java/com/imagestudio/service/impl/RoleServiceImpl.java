package com.imagestudio.service.impl;

import com.imagestudio.model.Role;
import com.imagestudio.repository.RoleRepository;
import com.imagestudio.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 07.04.17.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role delete(long id) {
        Role role = roleRepository.findOne(id);
        roleRepository.delete(role);
        return role;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role update(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
