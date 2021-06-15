package com.dao;

import com.faraponoff.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDAO extends JpaRepository<Role, Long> {

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void deleteRole(int id);

    Role saveRole(Role role);

    Role updateRole(Role role);

    Role getRoleByName(String roleName);
}
