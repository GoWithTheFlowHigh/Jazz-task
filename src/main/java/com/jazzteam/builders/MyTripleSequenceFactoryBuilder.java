package com.jazzteam.builders;

import com.jazzteam.factories.MyNamedClassFactoryRepository;
import com.jazzteam.factories.MyTripleSequenceFactory;
import com.jazzteam.interfaces.*;

public class MyTripleSequenceFactoryBuilder implements TripleSequenceFactoryBuilder {
    private NamedClassRepository namedClassRepository;
    private String source;
    private TripleFactory tripleFactory;
    private TripleSequenceBuilder tripleSequenceBuilder;

    public MyTripleSequenceFactoryBuilder() {
        reset();
    }

    @Override
    public void reset() {
        namedClassRepository = new MyNamedClassFactoryRepository().create();
        source = "";
        tripleFactory = new MyTripleFactoryBuilder().getResult();
        tripleSequenceBuilder = new MyTripleSequenceBuilder();
    }

    @Override
    public TripleSequenceFactoryBuilder withNamedClassRepository(NamedClassRepository namedClassRepository) {
        this.namedClassRepository = namedClassRepository;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withTripleFactory(TripleFactory tripleFactory) {
        this.tripleFactory = tripleFactory;
        return this;
    }

    @Override
    public TripleSequenceFactoryBuilder withTripleSequenceBuilder(TripleSequenceBuilder tripleSequenceBuilder) {
        this.tripleSequenceBuilder = tripleSequenceBuilder;
        return this;
    }

    @Override
    public TripleSequenceFactory getResult() {
        TripleSequenceFactory result = new MyTripleSequenceFactory();
        result.setSource(source);
        result.setNamedClassRepository(namedClassRepository);
        result.setTripleFactory(tripleFactory);
        result.setTripleSequenceBuilder(tripleSequenceBuilder);
        return result;
    }

}
