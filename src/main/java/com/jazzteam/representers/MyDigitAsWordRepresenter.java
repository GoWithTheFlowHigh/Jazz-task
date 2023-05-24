package com.jazzteam.representers;

import com.jazzteam.interfaces.DigitAsWordRepresenter;
import com.jazzteam.models.Digit;
import com.jazzteam.models.Grammar;

public class MyDigitAsWordRepresenter implements DigitAsWordRepresenter {
    private Digit digit;
    private Grammar.Gender gender;

    @Override
    public void reset() {
        digit = null;
        gender = Grammar.Gender.MALE;
    }

    @Override
    public String transcript(Digit digit) {
        this.digit = digit;
        return getResult();
    }

    @Override
    public DigitAsWordRepresenter withGender(Grammar.Gender gender) {
        this.gender = gender;
        return this;
    }

    private String getResult() {
        assert (digit != null);
        String result = digit.getGenderForm(gender);
        if (result.isEmpty() && gender != Grammar.Gender.MALE) {
            result = digit.getGenderForm(Grammar.Gender.MALE);
        }
        return result;
    }
}
