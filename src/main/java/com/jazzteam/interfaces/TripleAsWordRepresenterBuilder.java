package com.jazzteam.interfaces;

import com.jazzteam.models.Triple;


public interface TripleAsWordRepresenterBuilder extends TripleRepresenterBuilder<String> {
    TripleRepresenterBuilder withDigitsGenderFormsBuilder(DigitAsWordRepresenter digitAsWordRepresenter);

    TripleRepresenterBuilder withNamedOrdersFormsBuilder(NamedClassAsWordRepresenter namedOrdersFormsRepresenter);

    TripleRepresenterBuilder withTriple(Triple triple);

}
