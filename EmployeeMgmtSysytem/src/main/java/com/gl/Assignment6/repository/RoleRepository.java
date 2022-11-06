package com.gl.Assignment6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.Assignment6.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
