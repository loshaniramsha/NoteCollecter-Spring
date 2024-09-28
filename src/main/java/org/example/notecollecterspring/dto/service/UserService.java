package org.example.notecollecterspring.dto.service;

import org.example.notecollecterspring.dto.dto.impl.NoteDTO;
import org.example.notecollecterspring.dto.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    UserDTO getUser(String userId);
    boolean deleteNote(String userId);
    boolean updateNote(String userId, UserDTO userDTO);
}
