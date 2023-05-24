package com.jazzteam.interfaces;

import com.jazzteam.models.Digit;

public interface DigitRepository extends DictionaryRepository<Digit> {
    Digit getDigitByPositionInTripleAndSymbol(String number, int positionInClass);
}
