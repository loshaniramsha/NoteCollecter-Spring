package org.example.notecollecterspring.dto.service;

import org.example.notecollecterspring.dto.dto.impl.NoteDTO;

import java.util.List;

public interface NotService {
    NoteDTO saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNote();
    NoteDTO getNote(String noteId);
    boolean deleteNote(String noteId);
    boolean updateNote(String noteId, NoteDTO noteDTO);
}
