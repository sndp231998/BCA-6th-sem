package com.sandip.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandip.blog.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
