package org.example.notecollecterspring.dto.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notecollecterspring.dto.dto.impl.NoteDTO;
import org.example.notecollecterspring.dto.entity.SuperEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")

public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String profilepic;
    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;
}
