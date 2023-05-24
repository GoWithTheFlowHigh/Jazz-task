package com.jazzteam.representers;

import com.jazzteam.builders.MyGrammarBuilder;
import com.jazzteam.interfaces.NamedClassAsWordRepresenter;
import com.jazzteam.interfaces.SuffixRepository;
import com.jazzteam.models.Grammar;
import com.jazzteam.models.NamedClass;

public class MyNamedClassAsWordRepresenter implements NamedClassAsWordRepresenter {
    private Grammar.Form form;
    private Grammar.Case aCase;
    private NamedClass namedClass;
    private SuffixRepository suffixRepository;

    @Override
    public NamedClassAsWordRepresenter withSuffixRepository(SuffixRepository suffixRepository) {
        this.suffixRepository = suffixRepository;
        return this;
    }

    @Override
    public NamedClassAsWordRepresenter withForm(Grammar.Form form) {
        this.form = form;
        return this;
    }

    @Override
    public NamedClassAsWordRepresenter withCase(Grammar.Case aCase) {
        this.aCase = aCase;
        return this;
    }


    @Override
    public String transcript(NamedClass namedClass) {
        this.namedClass = namedClass;
        return getResult();
    }

    @Override
    public void reset() {
        form = Grammar.Form.SINGULAR;
        aCase = Grammar.Case.NOMINATIVE;
    }

    private String getResult() {
        String result = namedClass.initOrGetCasesByForm(form).get(aCase);
        if (result.isEmpty() && !namedClass.getRoot().isEmpty()) {
            Grammar grammar =
                    new MyGrammarBuilder().withCase(aCase)
                            .withForm(form)
                            .withGender(namedClass.getGender())
                            .getResult();
            result = namedClass.getRoot();
            result += suffixRepository.getSuffixByGrammar(grammar).getValue();
        }
        return result;
    }

    public SuffixRepository getSuffixRepository() {
        return this.suffixRepository;
    }

    public void setSuffixesRepository(SuffixRepository suffixRepository) {
        this.suffixRepository = suffixRepository;
    }
}
