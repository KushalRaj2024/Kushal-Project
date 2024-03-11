package com.jokes.JokesDemo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jokes")
public class Joke {
    private String type;
    private String  setup;

    private String punchline;

    private String id;

    public Joke(){

    }

    public Joke(String type, String setup, String punchline, String id) {
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
        this.id = id;
    }

    public Joke(String s) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
