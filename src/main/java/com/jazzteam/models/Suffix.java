package com.jazzteam.models;

public class Suffix {
    private Grammar grammar;
    private String value;

    public Suffix() {
    }

    public Suffix(Grammar grammar, String value) {
        this.grammar = grammar;
        this.value = value;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
