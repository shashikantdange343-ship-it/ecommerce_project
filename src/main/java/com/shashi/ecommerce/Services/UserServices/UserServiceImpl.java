package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.DTOs.UserDTOs.AuthDTOs;
import com.shashi.ecommerce.Entity.UsersEntity.Roles;
import com.shashi.ecommerce.Entity.UsersEntity.User;
import com.shashi.ecommerce.Repository.UserRepositories.RolesRepository;
import com.shashi.ecommerce.Repository.UserRepositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RolesRepository rolesRepository;

    @Override
    public AuthDTOs.RegisterResponseDTO registerUser(AuthDTOs.RegisterRequestDTO request) {

        User user = new User();
        user.setUsername(request.userName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setFirst_name(request.firstName());
        user.setLast_name(request.lastName());
        user.setPhone_no(request.PhoneNo());

        Optional<Roles> optionalUserRole = rolesRepository.findByRoleName("ROLE_CUSTOMER");

        if (optionalUserRole.isEmpty()){
            throw new RuntimeException("Role Does Not Exists !");
        }

        Roles userRole = optionalUserRole.get();

        user.setRoles(List.of(userRole));

        userRepository.save(user);

        return new AuthDTOs.RegisterResponseDTO("success");
    }
}
