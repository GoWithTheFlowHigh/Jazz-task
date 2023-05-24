package com.jazzteam.builders;

import com.jazzteam.models.Triple;
import com.jazzteam.models.TripleSequence;
import com.jazzteam.interfaces.TripleSequenceBuilder;

import java.util.LinkedList;
import java.util.List;

public class MyTripleSequenceBuilder implements TripleSequenceBuilder {
    private TripleSequence result;

    public MyTripleSequenceBuilder() {
        reset();
    }

    @Override
    public void reset() {
        result = new TripleSequence();
        withTriples(new LinkedList<>());
    }

    public TripleSequenceBuilder withTriples(Triple... triples) {
        for (Triple triple : triples) {
            result.getTriples().add(triple);
        }
        return this;
    }

    @Override
    public TripleSequenceBuilder withTriples(List<Triple> triples) {
        result.setTriples(triples);
        return this;
    }

    @Override
    public TripleSequence getResult() {
        return result;
    }

}
