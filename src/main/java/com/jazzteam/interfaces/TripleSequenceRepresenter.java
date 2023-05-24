package com.jazzteam.interfaces;

import com.jazzteam.models.TripleSequence;


public interface TripleSequenceRepresenter<T> extends Representer<TripleSequence, T> {
    TripleSequenceRepresenter<T> withTripleRepresenter(TripleRepresenter<T> tripleRepresenter);
}
