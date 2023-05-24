package com.jazzteam.factories;

import com.jazzteam.services.MyDigitRepository;
import com.jazzteam.interfaces.DigitsFactoryRepository;

public class MyDigitFactoryRepository implements DigitsFactoryRepository {

    @Override
    public String getSourceName() {
        return "digits.yaml";
    }

    @Override
    public Class getRepositoryClass() {
        return MyDigitRepository.class;
    }
}
