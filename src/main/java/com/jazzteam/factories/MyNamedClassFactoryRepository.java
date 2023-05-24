package com.jazzteam.factories;

import com.jazzteam.services.MyNamedClassRepository;
import com.jazzteam.interfaces.NamedClassFactoryRepository;

public class MyNamedClassFactoryRepository implements NamedClassFactoryRepository {
    @Override
    public String getSourceName() {
        return "named_indexes.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return MyNamedClassRepository.class;
    }
}
