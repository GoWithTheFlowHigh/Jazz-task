package com.jazzteam.builders;

import com.jazzteam.models.Grammar;
import com.jazzteam.interfaces.GrammarBuilder;

public class MyGrammarBuilder implements GrammarBuilder {
    private Grammar result;
    private Grammar.Case aCase;
    private Grammar.Form form;
    private Grammar.Gender gender;

    public MyGrammarBuilder() {
        reset();
    }

    @Override
    public void reset() {
        result = new Grammar();
        aCase = Grammar.Case.GENITIVE;
        form = Grammar.Form.PLURAL;
        gender = Grammar.Gender.MALE;
    }


    @Override
    public GrammarBuilder withCase(Grammar.Case aCase) {
        this.aCase = aCase;
        return this;
    }

    @Override
    public GrammarBuilder withForm(Grammar.Form form) {
        this.form = form;
        return this;
    }

    @Override
    public GrammarBuilder withGender(Grammar.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Grammar getResult() {
        result.setCase(aCase);
        result.setForm(form);
        result.setGender(gender);
        return result;
    }

}
