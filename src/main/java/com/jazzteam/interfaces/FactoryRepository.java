package com.jazzteam.interfaces;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public interface FactoryRepository<T extends DictionaryRepository> extends Factory<T> {
    String getSourceName();

    Class getRepositoryClass();

    default T create() {
        Constructor ctr = new Constructor(getRepositoryClass());
        Yaml yaml = new Yaml(ctr);
        InputStream inputStream = getRepositoryClass()
                .getClassLoader()
                .getResourceAsStream(getSourceName());
        T result = yaml.load(inputStream);
        return result;
    }
}
