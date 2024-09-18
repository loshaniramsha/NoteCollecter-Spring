package org.example.notecollecterspring.dto.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notecollecterspring.dto.entity.SuperEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "note")

public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTittle;
    private String noteDesc;
    private String createDate;
    private String priorityLevel;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
}
