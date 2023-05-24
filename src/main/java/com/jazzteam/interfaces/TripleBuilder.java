package com.jazzteam.interfaces;

import com.jazzteam.models.Digit;
import com.jazzteam.models.NamedClass;
import com.jazzteam.models.Triple;


public interface TripleBuilder extends Builder<Triple> {
    TripleBuilder withNamedClass(NamedClass namedClass);

    TripleBuilder withDigits(Digit... digits);
}
