package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;

public interface GrammarBuilder extends Builder<Grammar> {
    GrammarBuilder withCase(Grammar.Case aCase);

    GrammarBuilder withForm(Grammar.Form form);

    GrammarBuilder withGender(Grammar.Gender gender);
}
