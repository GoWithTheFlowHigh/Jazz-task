package com.jazzteam.interfaces;

import java.util.List;

public interface DictionaryRepository<T> {
    List<T> getItems();

    void setItems(List<T> items);
}
