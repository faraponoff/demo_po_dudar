package com.boots.dao;

import com.boots.model.Role;

import java.util.List;

public interface RoleDAO{

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void deleteRole(int id);

    Role saveRole(Role role);

    Role updateRole(Role role);

    Role getRoleByName(String roleName);
}
