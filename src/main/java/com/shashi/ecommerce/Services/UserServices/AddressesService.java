package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.DTOs.UserDTOs.AddressDTOs;
import com.shashi.ecommerce.Entity.UsersEntity.Addresses;

import java.util.List;

public interface AddressesService {

    List<AddressDTOs.SetAddressResponseDTO> getAddresses(String userName);

    Addresses getAddress(long addressId);

    AddressDTOs.SetAddressResponseDTO setNewAddress(AddressDTOs.SetAddressRequestDTO requestDTO , String userName );

}
