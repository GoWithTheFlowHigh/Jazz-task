package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;

public interface DigitAsWordRepresenterBuilder extends DigitRepresenterBuilder<String> {
    DigitAsWordRepresenterBuilder withGender(Grammar.Gender gender);
}
