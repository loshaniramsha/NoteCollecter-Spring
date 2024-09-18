package org.example.notecollecterspring.dto.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notecollecterspring.dto.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class NoteDTO implements SuperDTO {
    private String noteId;
    private String noteTittle;
    private String noteDesc;
    private String createDate;
    private String priorityLevel;
    private String userId;
}
