package org.example.repository;

import org.example.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class NotesJdbsRepository implements NotesRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NotesJdbsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Note> findall(){
        return jdbcTemplate.query("SELECT * FROM person",
                (rs, rowNum) -> new Note(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));

    }

    @Override
    public void deleteNote(Note note) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", note.getId());
    }

    @Override
    public void save(Note note) {
        jdbcTemplate.update("INSERT INTO person(first_name, last_name) VALUES (?,?)", note.getName(), note.getText());
    }

}
