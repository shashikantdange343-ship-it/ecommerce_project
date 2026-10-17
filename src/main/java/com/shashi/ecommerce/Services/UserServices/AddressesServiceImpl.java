package com.shashi.ecommerce.Services.UserServices;

import com.shashi.ecommerce.DTOs.UserDTOs.AddressDTOs;
import com.shashi.ecommerce.Entity.UsersEntity.Addresses;
import com.shashi.ecommerce.Exceptons.CustomException;
import com.shashi.ecommerce.Exceptons.ResourceNotFoundException;
import com.shashi.ecommerce.Repository.UserRepositories.AddressRepository;
import com.shashi.ecommerce.Services.ClassConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressesServiceImpl implements AddressesService{

    private final AddressRepository addressRepository;

    private final ClassConverterService classConverterService;

    private final UserService userService;

    @Override
    public List<AddressDTOs.SetAddressResponseDTO> getAddresses(String userName) {

        Optional<List<Addresses>> optionalAddresses = addressRepository.findByUserUsername(userName);

        if (optionalAddresses.isEmpty()){
            throw new CustomException("Please Add a Address First !");
        }

        return optionalAddresses.get().stream().map(classConverterService::addressResponseDTO).toList();
    }

    @Override
    public Addresses getAddress(long addressId) {

        Optional<Addresses> address = addressRepository.findById(addressId);

        if (address.isEmpty()){
            throw new CustomException("Please Add Address First !");
        }

        return address.get();
    }


    @Override
    public AddressDTOs.SetAddressResponseDTO setNewAddress(AddressDTOs.SetAddressRequestDTO requestDTO,String userName) {

        Addresses address = new Addresses();

        address.setUser(userService.getUser(userName));
        address.setStreet(requestDTO.street());
        address.setState(requestDTO.state());
        address.setCity(requestDTO.city());
        address.setAddressType(requestDTO.addressType());
        address.setPinCode(requestDTO.pinCode());
        address.setIsDefault(requestDTO.isDefault());

        return classConverterService.addressResponseDTO(addressRepository.save(address));
    }

}

