package com.jazzteam.services;

import com.jazzteam.models.Digit;
import com.jazzteam.interfaces.DigitRepository;

import java.util.List;


public class MyDigitRepository implements DigitRepository {
    private List<Digit> items;

    @Override
    public List<Digit> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Digit> items) {
        this.items = items;
    }

    @Override
    public Digit getDigitByPositionInTripleAndSymbol(String number, int positionInClass) {
        Digit result =
                items.stream()
                        .filter(d -> d.getNumber().equals(number) && d.getPositionInClass() == positionInClass)
                        .findFirst()
                        .orElse(null);
        return result;
    }

}
