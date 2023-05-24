package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;


public interface DigitAsWordRepresenter extends DigitRepresenter<String> {

    DigitAsWordRepresenter withGender(Grammar.Gender gender);
}
