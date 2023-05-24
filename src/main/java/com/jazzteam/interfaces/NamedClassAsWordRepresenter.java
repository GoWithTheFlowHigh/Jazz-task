package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;

public interface NamedClassAsWordRepresenter extends NamedClassRepresenter<String> {
    NamedClassAsWordRepresenter withSuffixRepository(SuffixRepository suffixRepository);

    NamedClassAsWordRepresenter withForm(Grammar.Form requiredForm);

    NamedClassAsWordRepresenter withCase(Grammar.Case requiredCase);

}
