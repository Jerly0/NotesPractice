package org.example.service;

import org.example.domain.Note;
import org.example.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NotesService implements NotesServiceInt{

    private final NotesRepository notesRepository;

    @Autowired
    public  NotesService(NotesRepository notesRepository){
        this.notesRepository = notesRepository;
    }

    public Collection<Note> getAllNotes(){
        return notesRepository.findall();
    }

    public void createNote(Note note){
        notesRepository.save(note);
    }

    public void deleteNote(Note note){
        notesRepository.deleteNote(note);
    }

}
