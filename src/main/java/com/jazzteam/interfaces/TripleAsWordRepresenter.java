package com.jazzteam.interfaces;


public interface TripleAsWordRepresenter extends TripleRepresenter<String> {
    DigitRepresenter getDigitAsWordRepresenter();

    TripleAsWordRepresenter withDigitGenderFormsBuilder(DigitAsWordRepresenter digitAsWordRepresenter);

    TripleAsWordRepresenter withNamedClassFormsBuilder(NamedClassAsWordRepresenter namedOrdersFormsRepresenter);
}
