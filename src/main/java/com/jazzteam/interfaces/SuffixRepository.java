package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;
import com.jazzteam.models.Suffix;

public interface SuffixRepository extends DictionaryRepository<Suffix> {
    Suffix getSuffixByGrammar(Grammar grammar);
}
