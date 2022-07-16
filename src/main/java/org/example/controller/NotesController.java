package org.example.controller;

import org.example.domain.Note;
import org.example.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;
    List<Note> notesList = new ArrayList<>(Arrays.asList());

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public Collection<Note> getNotes(){
        return notesList;
    }

    @PostMapping
    public Collection<Note> addNote(@RequestBody @Valid Note tempNote){

        for(Note note : notesList){
            if((!tempNote.getName().equals(note.getName())) && (!tempNote.getText().equals(note.getText()))){
                notesList.add(tempNote);
                notesService.createNote(tempNote);
            }
        }
        return notesList;

    }

    @DeleteMapping
    public void deleteNote(Note tempNote){

        notesService.deleteNote(tempNote);
        notesList.remove(tempNote);

    }


}
