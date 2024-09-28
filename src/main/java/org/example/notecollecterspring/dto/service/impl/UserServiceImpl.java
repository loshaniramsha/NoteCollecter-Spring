package org.example.notecollecterspring.dto.service.impl;

import jakarta.transaction.Transactional;
import org.example.notecollecterspring.dto.dao.UserDAO;
import org.example.notecollecterspring.dto.dto.impl.NoteDTO;
import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.entity.impl.UserEntity;
import org.example.notecollecterspring.dto.service.NotService;
import org.example.notecollecterspring.dto.service.UserService;
import org.example.notecollecterspring.dto.util.AppUtil;
import org.example.notecollecterspring.dto.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
   private UserDAO userDAO;
    @Autowired
    private Mapping mapping;


    @Override
    public UserDTO saveUser(UserDTO userDTO) {
       UserEntity savedUser=userDAO.save(mapping.toUserEntity(userDTO));
        return  mapping.toUserDTO(savedUser);

        //return  mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUser() {
        return List.of();
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public boolean deleteNote(String userId) {
        return false;
    }

    @Override
    public boolean updateNote(String userId, UserDTO userDTO) {
        return false;
    }
}
