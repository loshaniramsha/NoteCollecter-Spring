package org.example.notecollecterspring.dto.dto.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notecollecterspring.dto.dto.SuperDTO;
import org.example.notecollecterspring.dto.entity.impl.NoteEntity;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO implements SuperDTO{
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilepic;
    private List<NoteDTO> notes;
}
