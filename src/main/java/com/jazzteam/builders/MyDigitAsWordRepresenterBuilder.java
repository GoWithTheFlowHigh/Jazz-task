package com.jazzteam.builders;

import com.jazzteam.models.Grammar;
import com.jazzteam.interfaces.DigitAsWordRepresenter;
import com.jazzteam.interfaces.DigitAsWordRepresenterBuilder;
import com.jazzteam.representers.MyDigitAsWordRepresenter;

public class MyDigitAsWordRepresenterBuilder implements DigitAsWordRepresenterBuilder {
    private Grammar.Gender gender;

    public MyDigitAsWordRepresenterBuilder() { reset(); }

    @Override
    public DigitAsWordRepresenterBuilder withGender(Grammar.Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public DigitAsWordRepresenter getResult() {
        DigitAsWordRepresenter result = new MyDigitAsWordRepresenter();
        result.withGender(gender);
        return result;
    }

    @Override
    public void reset() {
        gender = Grammar.Gender.MALE;
    }
}
