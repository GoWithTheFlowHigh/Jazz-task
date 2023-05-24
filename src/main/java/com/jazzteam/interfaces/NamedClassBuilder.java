package com.jazzteam.interfaces;

import com.jazzteam.models.Grammar;
import com.jazzteam.models.NamedClass;

import java.util.Map;

public interface NamedClassBuilder extends Builder<NamedClass> {
    NamedClassBuilder withForms(Map<Grammar.Form, Map<Grammar.Case, String>> forms);

    NamedClassBuilder withGender(Grammar.Gender gender);

    NamedClassBuilder withNumber(int number);

    NamedClassBuilder withRoot(String root);
}
