package org.example.repository;

import org.example.domain.Note;

import java.util.Collection;

public interface NotesRepository {

    Collection<Note> findall();
    void deleteNote(Note note);
    void save(Note note);

}
