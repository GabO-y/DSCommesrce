package com.GabrielOliveira.DScommerce.Services;


import com.GabrielOliveira.DScommerce.Repository.UserRepository;
import com.GabrielOliveira.DScommerce.dto.UserDTO;
import com.GabrielOliveira.DScommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO findById(Long id){
        return new UserDTO(repository.findById(id).orElseThrow());
    }

}
