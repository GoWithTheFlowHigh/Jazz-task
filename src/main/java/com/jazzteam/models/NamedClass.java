package com.jazzteam.models;

import java.util.HashMap;
import java.util.Map;

public class NamedClass {
    private Map<Grammar.Form, Map<Grammar.Case, String>> forms;
    private Grammar.Gender gender;
    private int index;
    private String root;

    public NamedClass() {
        this.gender = Grammar.Gender.MALE;
        this.forms = new HashMap<>();
    }

    public Grammar.Gender getGender() {
        return gender;
    }

    public void setGender(Grammar.Gender gender) {
        this.gender = gender;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public String getSingular(Grammar.Case wordCase) {
        return getSingularCases().get(wordCase);
    }

    public void setSingular(Grammar.Case wordCase, String word) {
        getSingularCases().put(wordCase, word);
    }

    public String getPlural(Grammar.Case wordCase) {
        return getPluralCases().get(wordCase);
    }

    public void setPlural(Grammar.Case wordCase, String word) {
        getPluralCases().put(wordCase, word);
    }


    public Map<Grammar.Case, String> getCasesByForm(Grammar.Form form) {
        return forms.get(form);
    }

    public void setForm(Grammar.Form form, Map<Grammar.Case, String> cases) {
        forms.put(form, cases);
    }

    public Map<Grammar.Case, String> getSingularCases() {
        return initOrGetCasesByForm(
                Grammar.Form.SINGULAR);
    }

    public Map<Grammar.Case, String> getPluralCases() {
        return initOrGetCasesByForm(
                Grammar.Form.PLURAL);
    }

    public Map<Grammar.Case, String> initOrGetCasesByForm(Grammar.Form form) {
        Map<Grammar.Case, String> result = getCasesByForm(form);
        if (result == null) {
            result = new HashMap<Grammar.Case, String>() {{
                put(Grammar.Case.NOMINATIVE, "");
                put(Grammar.Case.GENITIVE, "");
            }};
            setForm(form, result);
        }
        return result;
    }

    public Map<Grammar.Form, Map<Grammar.Case, String>> getForms() {
        return forms;
    }

    public void setForms(Map<Grammar.Form, Map<Grammar.Case, String>> forms) {
        this.forms = forms;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

}
