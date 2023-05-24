package com.jazzteam.builders;

import com.jazzteam.factories.MyDigitFactoryRepository;
import com.jazzteam.factories.MyTripleFactory;
import com.jazzteam.interfaces.DigitRepository;
import com.jazzteam.interfaces.TripleBuilder;
import com.jazzteam.interfaces.TripleFactory;
import com.jazzteam.interfaces.TripleFactoryBuilder;

public class MyTripleFactoryBuilder implements TripleFactoryBuilder {
    private DigitRepository digitRepository;
    private TripleBuilder tripleBuilder;
    private String source;

    public MyTripleFactoryBuilder() {
        reset();
    }

    @Override
    public void reset() {
        digitRepository = new MyDigitFactoryRepository().create();
        tripleBuilder = new MyTripleBuilder();
        source = "";
    }

    @Override
    public TripleFactoryBuilder withTripleBuilder(TripleBuilder tripleBuilder) {
        this.tripleBuilder = tripleBuilder;
        return this;
    }

    @Override
    public TripleFactoryBuilder withDigitRepository(DigitRepository digitRepository) {
        this.digitRepository = digitRepository;
        return this;
    }

    @Override
    public TripleFactoryBuilder withSource(String source) {
        this.source = source;
        return this;
    }

    public TripleFactory getResult() {
        TripleFactory result = new MyTripleFactory();
        result.setSource(source);
        result.setDigitsRepository(digitRepository);
        result.setTripleBuilder(tripleBuilder);
        return result;
    }

}
