package org.example.service;

import org.apache.tomcat.util.bcel.classfile.AnnotationEntry;
import org.example.domain.Note;

import java.util.Collection;

public interface NotesServiceInt {

    Collection<Note> getAllNotes();

    void createNote(Note note);

    void deleteNote(Note note);

}
