package com.jazzteam.representers;

import com.jazzteam.builders.MyTripleAsWordRepresenterBuilder;
import com.jazzteam.builders.MyTripleSequenceBuilder;
import com.jazzteam.interfaces.TripleAsWordRepresenter;
import com.jazzteam.interfaces.TripleRepresenter;
import com.jazzteam.interfaces.TripleSequenceAsWordRepresenter;
import com.jazzteam.models.TripleSequence;

import java.util.List;
import java.util.stream.Collectors;

public class MyTripleSequenceAsWordRepresenter implements TripleSequenceAsWordRepresenter {
    private TripleAsWordRepresenter tripleAsWordRepresenter;
    private TripleSequence tripleSequence;

    @Override
    public TripleSequenceAsWordRepresenter withTripleRepresenter(TripleRepresenter tripleRepresenter) {
        this.tripleAsWordRepresenter = (TripleAsWordRepresenter) tripleRepresenter;
        return this;
    }

    @Override
    public String transcript(TripleSequence sourceTripleSequence) {
        this.tripleSequence = sourceTripleSequence;
        return getResult();
    }

    private String getResult() {
        List<String> tripleSequencesAsString =
                tripleSequence.getTriples()
                        .stream()
                        .filter(triple -> !triple.isEmpty())
                        .map(triple -> tripleAsWordRepresenter.transcript(triple))
                        .collect(Collectors.toList());
        String result = String.join(" ", tripleSequencesAsString).trim();
        return result;
    }

    @Override
    public void reset() {
        tripleAsWordRepresenter = new MyTripleAsWordRepresenterBuilder().getResult();
        tripleSequence = new MyTripleSequenceBuilder().getResult();
    }
}

