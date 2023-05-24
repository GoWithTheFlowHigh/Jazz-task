package com.jazzteam.services;

import com.jazzteam.models.Grammar;
import com.jazzteam.models.Suffix;
import com.jazzteam.interfaces.SuffixRepository;

import java.util.List;

public class MySuffixRepository implements SuffixRepository {
    List<Suffix> items;

    @Override
    public Suffix getSuffixByGrammar(Grammar grammar) {
        Suffix result = items.stream()
                             .filter(s -> s.getGrammar().equals(grammar))
                             .findFirst()
                             .orElse(null);
        return result;
    }

    @Override
    public List<Suffix> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Suffix> items) {
        this.items = items;
    }
}
