package com.jazzteam.interfaces;

import com.jazzteam.models.NamedClass;


public interface NamedClassRepository extends DictionaryRepository<NamedClass> {
    NamedClass getByNumber(int namedClassNumber);
}
