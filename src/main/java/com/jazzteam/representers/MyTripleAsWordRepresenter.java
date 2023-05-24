package com.jazzteam.representers;

import com.jazzteam.builders.MyDigitAsWordRepresenterBuilder;
import com.jazzteam.builders.MyNamedClassAsWordRepresenterBuilder;
import com.jazzteam.builders.MyTripleBuilder;
import com.jazzteam.interfaces.DigitAsWordRepresenter;
import com.jazzteam.interfaces.DigitRepresenter;
import com.jazzteam.interfaces.NamedClassAsWordRepresenter;
import com.jazzteam.interfaces.TripleAsWordRepresenter;
import com.jazzteam.models.Triple;

import java.util.List;
import java.util.stream.Collectors;

public class MyTripleAsWordRepresenter implements TripleAsWordRepresenter {
    private DigitAsWordRepresenter digitAsWordRepresenter;
    private NamedClassAsWordRepresenter namedClassAsWordRepresenter;
    private Triple triple;

    @Override
    public DigitRepresenter getDigitAsWordRepresenter() {
        return digitAsWordRepresenter;
    }

    @Override
    public TripleAsWordRepresenter withDigitGenderFormsBuilder(DigitAsWordRepresenter digitAsWordRepresenter) {
        this.digitAsWordRepresenter = digitAsWordRepresenter;
        return this;
    }

    @Override
    public TripleAsWordRepresenter withNamedClassFormsBuilder(NamedClassAsWordRepresenter namedClassFormsRepresenter) {
        this.namedClassAsWordRepresenter = namedClassFormsRepresenter;
        return this;
    }

    @Override
    public String transcript(Triple sourceTriple) {
        this.triple = sourceTriple;
        return getResult();
    }

    private String getResult() {
        assert (triple != null);
        assert (digitAsWordRepresenter != null);
        assert (namedClassAsWordRepresenter != null);
        digitAsWordRepresenter.reset();
        namedClassAsWordRepresenter.reset();
        String result = "";
        if (!triple.isEmpty()) {
            List<String> words = getCorrectFormOfDigits();
            words.add(getCorrectFormInNamedClass());
            result = String.join(" ", words).trim();
        }
        return result;
    }

    @Override
    public void reset() {
        namedClassAsWordRepresenter = new MyNamedClassAsWordRepresenterBuilder().getResult();
        digitAsWordRepresenter = new MyDigitAsWordRepresenterBuilder().getResult();
        triple = new MyTripleBuilder().getResult();
    }

    private List<String> getCorrectFormOfDigits() {
        List<String> result = triple.getDigits()
                .stream()
                .map(d -> digitAsWordRepresenter.withGender(triple.getGender()).transcript(d))
                .collect(Collectors.toList());
        return result;
    }

    private String getCorrectFormInNamedClass() {
        String result = namedClassAsWordRepresenter.withForm(triple.getForm())
                .withCase(triple.getCase())
                .transcript(triple.getNamedClass());
        return result;
    }
}
