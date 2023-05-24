package com.jazzteam.interfaces;


public interface TripleFactoryBuilder extends Builder<TripleFactory> {
    TripleFactoryBuilder withTripleBuilder(TripleBuilder tripleBuilder);

    TripleFactoryBuilder withDigitRepository(DigitRepository digitRepository);

    TripleFactoryBuilder withSource(String source);
}
