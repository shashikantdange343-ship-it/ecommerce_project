package com.shashi.ecommerce.Repository.UserRepositories;

import com.shashi.ecommerce.Entity.UsersEntity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Addresses, Long > {
    Optional<List<Addresses>> findByUserUsername(String userName);
}
