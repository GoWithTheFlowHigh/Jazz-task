package com.jazzteam.models;

import java.util.Map;


public class Digit {
    private Map<Grammar.Gender, String> genders;
    private Grammar.Case aCase;
    private Grammar.Form form;
    private String number;
    private int positionInClass;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Grammar.Form getForm() {
        return form == null ? Grammar.Form.PLURAL : form;
    }

    public void setForm(Grammar.Form form) {
        this.form = form;
    }

    public Grammar.Case getCase() {
        return aCase == null ? Grammar.Case.GENITIVE : aCase;
    }

    public void setCase(Grammar.Case aCase) {
        this.aCase = aCase;
    }

    public int getPositionInClass() {
        return positionInClass;
    }

    public void setPositionInClass(int positionInClass) {
        this.positionInClass = positionInClass;
    }

    public void setGenderForm(Grammar.Gender gender, String form) {
        genders.put(gender, form);
    }

    public String getGenderForm(Grammar.Gender gender) {
        String result = genders.get(gender);
        if (result == null) {
            result = "";
            genders.put(gender, result);
        }
        return result;
    }

    public Map<Grammar.Gender, String> getGenders() {
        return this.genders;
    }

    public void setGenders(Map<Grammar.Gender, String> genders) {
        this.genders = genders;
    }
}
