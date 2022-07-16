package org.example.domain;

import javax.validation.constraints.NotBlank;

public class Note {

    @NotBlank
    private String name;

    private String text;

    private Long id;

    public Note (Long id, String name, String text){
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setText(String text){
        this.text = text;
    }

}
