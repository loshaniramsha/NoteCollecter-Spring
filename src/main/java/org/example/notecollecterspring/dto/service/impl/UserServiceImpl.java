package org.example.notecollecterspring.dto.service.impl;

import jakarta.transaction.Transactional;
import org.example.notecollecterspring.dto.dao.UserDAO;
import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.entity.impl.UserEntity;
import org.example.notecollecterspring.dto.service.UserService;
import org.example.notecollecterspring.dto.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> allUsers=userDAO.findAll();
        return mapping.asUserDTOList(allUsers);
    }

    @Override
    public UserDTO getUser(String userId) {
        UserEntity selectedUser=userDAO.getReferenceById(userId);
        return mapping.toUserDTO(selectedUser);
    }

    @Override
    public void deleteUser(String userId) {
        userDAO.deleteById(userId);

    }

    @Override
    public void updatUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser=userDAO.findById(userId);
        if (tmpUser.isPresent()){
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilepic(userDTO.getProfilepic());
            userDAO.save(tmpUser.get());
        }
    }
}


