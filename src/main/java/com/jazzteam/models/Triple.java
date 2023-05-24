package com.jazzteam.models;

import java.util.List;

public class Triple {
    private List<Digit> digits;
    private NamedClass namedClass;

    public Grammar.Gender getGender() {
        assert (namedClass != null);
        return namedClass.getGender();
    }

    public Grammar.Case getCase() {
        assert (digits != null);
        Grammar.Case result = Grammar.Case.NOMINATIVE;
        if (!digits.isEmpty()) {
            result = digits.get(digits.size() - 1).getCase();
        }
        return result;
    }

    public Grammar.Form getForm() {
        assert (digits != null);
        Grammar.Form result = Grammar.Form.SINGULAR;
        if (!digits.isEmpty()) {
            result = digits.get(digits.size() - 1).getForm();
        }
        return result;
    }

    public List<Digit> getDigits() {
        return digits;
    }

    public void setDigits(List<Digit> digits) {
        assert (digits.size() <= 3);
        this.digits = digits;
    }


    public NamedClass getNamedClass() {
        return namedClass;
    }

    public void setNamedClass(NamedClass namedClass) {
        this.namedClass = namedClass;
    }

    public boolean isZero() {
        return digits.stream().allMatch(d -> d.getNumber().equals("0"));
    }

    public boolean isEmpty() {
        return isZero() && namedClass.getIndex() > 0;
    }
}
