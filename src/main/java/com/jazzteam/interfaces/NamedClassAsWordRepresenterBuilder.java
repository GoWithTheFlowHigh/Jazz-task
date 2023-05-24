package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;

public interface NamedClassAsWordRepresenterBuilder extends NamedClassRepresenterBuilder<String> {
    NamedClassRepresenterBuilder withForm(Grammar.Form form);

    NamedClassRepresenterBuilder withCase(Grammar.Case aCase);

    NamedClassRepresenterBuilder withSuffixesRepository(SuffixRepository suffixRepository);
}
