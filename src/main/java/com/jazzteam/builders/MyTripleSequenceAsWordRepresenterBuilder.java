package com.jazzteam.builders;

import com.jazzteam.interfaces.*;
import com.jazzteam.representers.MyTripleSequenceAsWordRepresenter;

public class MyTripleSequenceAsWordRepresenterBuilder implements TripleSequenceAsWordRepresenterBuilder {
    private TripleAsWordRepresenter tripleAsWordRepresenter;

    public MyTripleSequenceAsWordRepresenterBuilder() {
        reset();
    }

    @Override
    public void reset() {
        tripleAsWordRepresenter = new MyTripleAsWordRepresenterBuilder().getResult();
    }

    @Override
    public TripleSequenceRepresenterBuilder withTripleRepresenter(TripleRepresenter tripleRepresenter) {
        this.tripleAsWordRepresenter = (TripleAsWordRepresenter) tripleRepresenter;
        return this;
    }

    @Override
    public TripleSequenceAsWordRepresenter getResult() {
        TripleSequenceAsWordRepresenter result = new MyTripleSequenceAsWordRepresenter();
        result.withTripleRepresenter(tripleAsWordRepresenter);
        return result;
    }
}
