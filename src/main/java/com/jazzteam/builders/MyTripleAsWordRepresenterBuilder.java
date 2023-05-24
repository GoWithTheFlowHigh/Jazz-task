package com.jazzteam.builders;

import com.jazzteam.models.Triple;
import com.jazzteam.interfaces.*;
import com.jazzteam.representers.MyDigitAsWordRepresenter;
import com.jazzteam.representers.MyTripleAsWordRepresenter;


public class MyTripleAsWordRepresenterBuilder implements TripleAsWordRepresenterBuilder {
    private DigitAsWordRepresenter digitAsWordRepresenter;
    private NamedClassAsWordRepresenter namedClassFormsRepresenter;
    private Triple triple;

    public MyTripleAsWordRepresenterBuilder() {
        reset();
    }

    @Override
    public void reset() {
        digitAsWordRepresenter = new MyDigitAsWordRepresenter();
        namedClassFormsRepresenter = new MyNamedClassAsWordRepresenterBuilder().getResult();
    }

    @Override
    public TripleRepresenterBuilder withDigitsGenderFormsBuilder(DigitAsWordRepresenter digitAsWordRepresenter) {
        this.digitAsWordRepresenter = digitAsWordRepresenter;
        return this;
    }

    @Override
    public TripleRepresenterBuilder withNamedOrdersFormsBuilder(NamedClassAsWordRepresenter namedClassFormsRepresenter) {
        this.namedClassFormsRepresenter = namedClassFormsRepresenter;
        return this;
    }

    @Override
    public TripleRepresenterBuilder withTriple(Triple triple) {
        this.triple = triple;
        return this;
    }

    @Override
    public TripleAsWordRepresenter getResult() {
        TripleAsWordRepresenter result = new MyTripleAsWordRepresenter();
        result.withNamedClassFormsBuilder(namedClassFormsRepresenter);
        result.withDigitGenderFormsBuilder(digitAsWordRepresenter);
        return result;
    }
}
