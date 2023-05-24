package com.jazzteam.interfaces;

import com.jazzteam.models.Triple;


public interface TripleRepresenter<T> extends Representer<Triple, T> {
    TripleRepresenter<T> withDigitGenderFormsBuilder(DigitAsWordRepresenter digitAsWordRepresenter);

    TripleRepresenter<T> withNamedClassFormsBuilder(NamedClassAsWordRepresenter namedOrdersFormsRepresenter);
}
