package com.jazzteam.interfaces;

import com.jazzteam.models.TripleSequence;


public interface TripleSequenceRepresenterBuilder<T> extends RepresenterBuilder<Representer<TripleSequence, T>> {
    TripleSequenceRepresenterBuilder withTripleRepresenter(TripleRepresenter tripleRepresenter);
}
