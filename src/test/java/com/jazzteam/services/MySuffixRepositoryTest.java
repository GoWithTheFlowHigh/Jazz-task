package com.jazzteam.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.jazzteam.factories.MySuffixFactoryRepository;
import com.jazzteam.interfaces.SuffixRepository;
import com.jazzteam.models.Grammar;
import com.jazzteam.models.Suffix;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySuffixRepositoryTest {
    private static SuffixRepository suffixRepository;

    private static Stream<Arguments> suffixParams() {
        return Stream.of(
                Arguments.of(new Grammar(Grammar.Case.NOMINATIVE,
                        Grammar.Form.SINGULAR,
                        Grammar.Gender.MALE), ""),
                Arguments.of(new Grammar(Grammar.Case.GENITIVE,
                                Grammar.Form.SINGULAR,
                                Grammar.Gender.MALE),
                        "а"),
                Arguments.of(new Grammar(Grammar.Case.NOMINATIVE,
                        Grammar.Form.PLURAL,
                        Grammar.Gender.MALE), "ы"),
                Arguments.of(new Grammar(Grammar.Case.GENITIVE,
                        Grammar.Form.PLURAL,
                        Grammar.Gender.MALE), "ов"),
                Arguments.of(new Grammar(Grammar.Case.NOMINATIVE,
                        Grammar.Form.SINGULAR,
                        Grammar.Gender.FEMALE), "а"),
                Arguments.of(new Grammar(Grammar.Case.GENITIVE,
                        Grammar.Form.SINGULAR,
                        Grammar.Gender.FEMALE), "и"),
                Arguments.of(new Grammar(Grammar.Case.NOMINATIVE,
                        Grammar.Form.PLURAL,
                        Grammar.Gender.FEMALE), "и"),
                Arguments.of(new Grammar(Grammar.Case.GENITIVE,
                        Grammar.Form.PLURAL,
                        Grammar.Gender.FEMALE), "")
        );
    }

    @BeforeAll
    static void init() {
        suffixRepository = new MySuffixFactoryRepository().create();
    }

    @ParameterizedTest
    @DisplayName("Builds valid suffix by given params")
    @MethodSource("suffixParams")
    void buildsSuffixes(Grammar requiredGrammar,
                        String expectedSuffixValue) {
        Suffix actualSuffix = suffixRepository.getSuffixByGrammar(requiredGrammar);
        assertEquals(actualSuffix.getValue(), expectedSuffixValue);
    }
}
