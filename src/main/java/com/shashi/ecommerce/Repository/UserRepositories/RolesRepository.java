package com.shashi.ecommerce.Repository.UserRepositories;

import com.shashi.ecommerce.Entity.UsersEntity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRoleName(String name);
}
