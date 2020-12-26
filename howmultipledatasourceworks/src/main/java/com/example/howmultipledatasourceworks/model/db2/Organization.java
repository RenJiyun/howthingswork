package com.example.howmultipledatasourceworks.model.db2;

public class Organization {
    private long id;
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
