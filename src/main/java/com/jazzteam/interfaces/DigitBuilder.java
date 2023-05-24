package com.jazzteam.interfaces;

import com.jazzteam.models.Digit;
import com.jazzteam.models.Grammar;

import java.util.Map;

public interface DigitBuilder extends Builder<Digit> {
    DigitBuilder withGenders(Map<Grammar.Gender, String> genders);

    DigitBuilder withCase(Grammar.Case aCase);

    DigitBuilder withForm(Grammar.Form form);

    DigitBuilder withNumber(String number);

    DigitBuilder withPositionInClass(int positionInTriple);

    Digit getResult(Map<Grammar.Gender, String> genders, Grammar.Case aCase,
                    Grammar.Form form, String number);

}
