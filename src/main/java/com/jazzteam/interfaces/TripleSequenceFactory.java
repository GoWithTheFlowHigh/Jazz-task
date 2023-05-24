package com.jazzteam.interfaces;

import com.jazzteam.models.TripleSequence;

public interface TripleSequenceFactory extends Factory<TripleSequence> {
    String getSource();

    void setSource(String source);

    TripleFactory getTripleFactory();

    void setTripleFactory(TripleFactory tripleFactory);

    NamedClassRepository getNamedClassRepository();

    void setNamedClassRepository(NamedClassRepository namedClassRepository);

    TripleSequenceBuilder getTripleSequenceBuilder();

    void setTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder);
}
