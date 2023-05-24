package com.jazzteam.interfaces;

import com.jazzteam.models.Triple;
import com.jazzteam.models.TripleSequence;

import java.util.List;

public interface TripleSequenceBuilder extends Builder<TripleSequence> {
    TripleSequenceBuilder withTriples(List<Triple> triples);

    TripleSequence getResult();

    void reset();
}
