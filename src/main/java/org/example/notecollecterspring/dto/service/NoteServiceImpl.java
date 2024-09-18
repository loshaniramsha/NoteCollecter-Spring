package org.example.notecollecterspring.dto.service;

import org.example.notecollecterspring.dto.dto.impl.NoteDTO;
import org.example.notecollecterspring.dto.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class NoteServiceImpl implements NotService{

    private static List<NoteDTO> noteDTOS=new ArrayList<>();
    NoteServiceImpl(){
        noteDTOS.add(new NoteDTO("1","HTML","html-desc1","2024-01-01","lavel1","2"));
        noteDTOS.add(new NoteDTO("2","CSS","css-desc1","2024-08-01","lavel2","3"));
        noteDTOS.add(new NoteDTO("3","JS","js-desc1","2024-11-01","lavel3","4"));
        noteDTOS.add(new NoteDTO("4","JAVA","java-desc1","2023-01-01","lavel1","5"));
    }
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        noteDTOS.add(noteDTO);
        return noteDTO;

    }

    @Override
    public List<NoteDTO> getAllNote() {
        return List.of();
    }

    @Override
    public NoteDTO getNote(String noteId) {
        return null;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public boolean updateNote(String noteId, NoteDTO noteDTO) {
        return false;
    }
}
