package com.jazzteam.interfaces;


public interface TripleSequenceFactoryBuilder extends Builder<TripleSequenceFactory> {
    TripleSequenceFactoryBuilder withNamedClassRepository(NamedClassRepository namedClassRepository);

    TripleSequenceFactoryBuilder withSource(String source);

    TripleSequenceFactoryBuilder withTripleFactory(TripleFactory tripleFactory);

    TripleSequenceFactoryBuilder withTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder);
}
