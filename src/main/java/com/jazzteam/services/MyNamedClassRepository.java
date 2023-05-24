package com.jazzteam.services;

import com.jazzteam.models.NamedClass;
import com.jazzteam.interfaces.NamedClassRepository;

import java.util.List;

public class MyNamedClassRepository implements NamedClassRepository {
    private List<NamedClass> items;

    @Override
    public List<NamedClass> getItems() { return items; }

    @Override
    public void setItems(List<NamedClass> items) { this.items = items; }

    @Override
    public NamedClass getByNumber(int namedClassNumber) {
        NamedClass result =
                items.stream()
                     .filter(n -> n.getIndex() == namedClassNumber)
                     .findFirst()
                     .orElse(null);
        return result;
    }
}
