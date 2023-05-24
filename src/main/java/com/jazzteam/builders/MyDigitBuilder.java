package com.jazzteam.builders;

import com.jazzteam.models.Digit;
import com.jazzteam.models.Grammar;
import com.jazzteam.interfaces.DigitBuilder;

import java.util.HashMap;
import java.util.Map;

public class MyDigitBuilder implements DigitBuilder {
    Digit result;

    public MyDigitBuilder() {
        reset();
    }

    @Override
    public DigitBuilder withGenders(Map<Grammar.Gender, String> genders) {
        result.setGenders(genders);
        return this;
    }

    @Override
    public void reset() {
        result = new Digit();
        withGenders(new HashMap<>()).withForm(Grammar.Form.PLURAL).withNumber("").withCase(Grammar.Case.GENITIVE);
    }

    @Override
    public DigitBuilder withCase(Grammar.Case aCase) {
        result.setCase(aCase);
        return this;
    }

    @Override
    public DigitBuilder withForm(Grammar.Form form) {
        result.setForm(form);
        return this;
    }

    @Override
    public DigitBuilder withNumber(String number) {
        result.setNumber(number);
        return this;
    }

    @Override
    public DigitBuilder withPositionInClass(int positionInTriple) {
        result.setPositionInClass(positionInTriple);
        return this;
    }

    @Override
    public Digit getResult() {
        return result;
    }

    @Override
    public Digit getResult(Map<Grammar.Gender, String> genders, Grammar.Case aCase,
                           Grammar.Form form, String number) {
        return withGenders(genders).withCase(aCase).withForm(form).withNumber(number).getResult();
    }

}