package com.jazzteam.factories;

import com.jazzteam.services.MySuffixRepository;
import com.jazzteam.interfaces.SuffixesFactoryRepository;

public class MySuffixFactoryRepository implements SuffixesFactoryRepository {
    @Override
    public String getSourceName() {
        return "suffix.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return MySuffixRepository.class;
    }
}
