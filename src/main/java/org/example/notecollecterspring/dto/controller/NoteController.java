package org.example.notecollecterspring.dto.controller;

import org.example.notecollecterspring.dto.dto.impl.NoteDTO;
import org.example.notecollecterspring.dto.service.NotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")

public class NoteController {
    @Autowired
   private NotService notService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO){
        return notService.saveNote(noteDTO);

    }

    public NoteDTO getselectedNote(){
        return null;

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNote(){
        return notService.getAllNote();
    }

    public void deleteNote(String noteId){

    }

    public void uopdateNote(String noteId, NoteDTO noteDTO){


    }
}
