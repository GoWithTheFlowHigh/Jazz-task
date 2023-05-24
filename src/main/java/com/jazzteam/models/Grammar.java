package com.jazzteam.models;


public class Grammar {
    private Form form;
    private Case aCase;
    private Gender gender;

    public Grammar() {
    }

    public Grammar(Case aCase, Form form, Gender gender) {
        this.aCase = aCase;
        this.form = form;
        this.gender = gender;
    }

    public boolean equals(Grammar grammar) {
        return aCase == grammar.getaCase() && form == grammar.getForm() && gender == grammar.getGender();
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Case getaCase() {
        return aCase;
    }

    public void setCase(Case aCase) {
        this.aCase = aCase;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Form {
        PLURAL, SINGULAR
    }

    public enum Gender {
        MALE, FEMALE
    }

    public enum Case {
        NOMINATIVE, GENITIVE
    }
}
