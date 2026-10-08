package com.shashi.ecommerce.Repository.UserRepositories;

import com.shashi.ecommerce.Entity.UsersEntity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Addresses, Long > {
}
