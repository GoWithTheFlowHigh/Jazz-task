package com.jazzteam.builders;

import com.jazzteam.models.Grammar;
import com.jazzteam.models.NamedClass;
import com.jazzteam.interfaces.NamedClassBuilder;

import java.util.HashMap;
import java.util.Map;

public class MyNamedClassBuilder implements NamedClassBuilder {
    private Map<Grammar.Form, Map<Grammar.Case, String>> forms;
    private Grammar.Gender gender;
    private int index;
    private String root;

    @Override
    public NamedClassBuilder withForms(Map<Grammar.Form, Map<Grammar.Case, String>> forms) {
        this.forms = forms;
        return this;
    }

    @Override
    public NamedClassBuilder withGender(Grammar.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public NamedClassBuilder withNumber(int number) {
        this.index = number;
        return this;
    }

    @Override
    public NamedClassBuilder withRoot(String root) {
        this.root = root;
        return this;
    }

    @Override
    public NamedClass getResult() {
        NamedClass result = new NamedClass();
        result.setGender(gender);
        result.setForms(forms);
        result.setRoot(root);
        result.setIndex(index);
        return result;
    }
    @Override
    public void reset() {
        forms = new HashMap<>();
        gender = Grammar.Gender.MALE;
        index = 0;
        root = "";
    }
}
