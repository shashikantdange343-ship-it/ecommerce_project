package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.Entity.UsersEntity.Roles;
import com.shashi.ecommerce.Exceptons.CustomException;
import com.shashi.ecommerce.Repository.UserRepositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService{

    private final RolesRepository rolesRepository;

    @Override
    public Roles getRole(String role) {
        Optional<Roles> optionalUserRole = rolesRepository.findByRoleName("ROLE_CUSTOMER");

        if (optionalUserRole.isEmpty()){
            throw new CustomException("Role Not Found !");
        }

         return optionalUserRole.get();

    }
}
