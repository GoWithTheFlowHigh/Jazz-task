package com.jazzteam.interfaces;

import com.jazzteam.models.Triple;


public interface TripleFactory extends Factory<Triple> {

    TripleBuilder getTripleBuilder();

    void setTripleBuilder(TripleBuilder tripleBuilder);

    DigitRepository getDigitsRepository();

    void setDigitsRepository(DigitRepository digitRepository);

    String getSource();

    void setSource(String tripleAsString);
}
