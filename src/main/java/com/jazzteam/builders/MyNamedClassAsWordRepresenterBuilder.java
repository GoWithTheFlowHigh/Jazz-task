package com.jazzteam.builders;

import com.jazzteam.models.Grammar;
import com.jazzteam.factories.MySuffixFactoryRepository;
import com.jazzteam.interfaces.NamedClassAsWordRepresenter;
import com.jazzteam.interfaces.NamedClassAsWordRepresenterBuilder;
import com.jazzteam.interfaces.NamedClassRepresenterBuilder;
import com.jazzteam.interfaces.SuffixRepository;
import com.jazzteam.representers.MyNamedClassAsWordRepresenter;

public class MyNamedClassAsWordRepresenterBuilder implements NamedClassAsWordRepresenterBuilder {
    private Grammar.Form form;
    private Grammar.Case    aCase;
    private SuffixRepository suffixRepository;

    public MyNamedClassAsWordRepresenterBuilder() { reset(); }

    @Override
    public NamedClassRepresenterBuilder withForm(Grammar.Form form) {
        this.form = form;
        return this;
    }

    @Override
    public NamedClassRepresenterBuilder withCase(Grammar.Case aCase) {
        this.aCase = aCase;
        return this;
    }

    @Override
    public NamedClassRepresenterBuilder withSuffixesRepository(SuffixRepository suffixRepository) {
        this.suffixRepository = suffixRepository;
        return this;
    }

    @Override
    public NamedClassAsWordRepresenter getResult() {
        NamedClassAsWordRepresenter result = new MyNamedClassAsWordRepresenter();
        return result.withCase(aCase).withForm(form).withSuffixRepository(suffixRepository);
    }

    @Override
    public void reset() {
        aCase              = Grammar.Case.NOMINATIVE;
        form               = Grammar.Form.SINGULAR;
        suffixRepository = new MySuffixFactoryRepository().create();
    }
}
