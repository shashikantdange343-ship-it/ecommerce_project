package com.shashi.ecommerce.Controller.UserControllers;

import com.shashi.ecommerce.DTOs.UserDTOs.AddressDTOs;
import com.shashi.ecommerce.Services.UserServices.AddressesService;
import com.shashi.ecommerce.Services.UserServices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/address")
public class AddressController {

    private final AddressesService addressesService;

    @GetMapping
    public ResponseEntity<List<AddressDTOs.SetAddressResponseDTO>> getAddresses(Principal principal){
       return ResponseEntity.ok(addressesService.getAddresses(principal.getName()));
    }

    @PostMapping
    public ResponseEntity<AddressDTOs.SetAddressResponseDTO> setAddress(
            @RequestBody AddressDTOs.SetAddressRequestDTO requestDTO ,
            Principal principal
    ){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                addressesService.setNewAddress(requestDTO,principal.getName()));

    }

}
