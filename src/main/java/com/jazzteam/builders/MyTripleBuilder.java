package com.jazzteam.builders;

import com.jazzteam.models.Digit;
import com.jazzteam.models.NamedClass;
import com.jazzteam.models.Triple;
import com.jazzteam.interfaces.TripleBuilder;

import java.util.LinkedList;

public class MyTripleBuilder implements TripleBuilder {
    private Triple result;

    public MyTripleBuilder() {
        reset();
    }

    @Override
    public void reset() {
        result = new Triple();
        result.setDigits(new LinkedList<>());
        result.setNamedClass(new NamedClass());
    }

    @Override
    public TripleBuilder withNamedClass(NamedClass namedClass) {
        result.setNamedClass(namedClass);
        return this;
    }

    @Override
    public TripleBuilder withDigits(Digit... digits) {
        assert (result.getDigits().size() + digits.length <= 3);
        for (Digit digit : digits) {
            result.getDigits().add(digit);
        }
        return this;
    }

    @Override
    public Triple getResult() {
        return result;
    }
}
