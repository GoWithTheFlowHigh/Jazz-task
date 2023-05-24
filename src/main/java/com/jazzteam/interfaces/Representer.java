package com.jazzteam.interfaces;


public interface Representer<S, T> {
    T transcript(S source);

    void reset();
}
