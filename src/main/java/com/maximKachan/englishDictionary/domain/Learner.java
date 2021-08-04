package com.maximKachan.englishDictionary.domain;

import java.time.LocalDate;

public class Learner {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private LocalDate dateOfBirth;

    public Learner(String name, String surName, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
