package com.imagestudio.service;

import com.imagestudio.model.Role;

import java.util.List;

/**
 * Created by alt on 07.04.17.
 */
public interface RoleService {
    Role create(Role role);

    Role delete(long id);

    List<Role> findAll();

    Role update(Role role);

    Role findById(long id);

    Role findByName(String name);
}
