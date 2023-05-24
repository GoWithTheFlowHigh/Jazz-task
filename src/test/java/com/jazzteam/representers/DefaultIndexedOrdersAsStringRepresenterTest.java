package com.jazzteam.representers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.jazzteam.builders.MyNamedClassAsWordRepresenterBuilder;
import com.jazzteam.interfaces.NamedClassAsWordRepresenter;
import com.jazzteam.models.Grammar;
import com.jazzteam.models.NamedClass;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultIndexedOrdersAsStringRepresenterTest {
    private static NamedClassAsWordRepresenter namedOrdersAsStringRepresenter;

    private static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(2, "миллион", Grammar.Gender.MALE, "миллион", "миллиона", "миллионы", "миллионов"),
                Arguments.of(1, "тысяч", Grammar.Gender.FEMALE, "тысяча", "тысячи", "тысячи", "тысяч"),
                Arguments.of(0, "", Grammar.Gender.MALE, "", "", "", "")
        );
    }

    @BeforeAll
    static void init() {
        namedOrdersAsStringRepresenter = new MyNamedClassAsWordRepresenterBuilder().getResult();
    }

    @AfterEach
    void reset() {
        namedOrdersAsStringRepresenter.reset();
    }

    @ParameterizedTest
    @DisplayName("Builds correct forms of named order, considering it gender")
    @MethodSource("namedOrders")
    void buildsNamedOrdersForms(int namedOrderNumber, String root, Grammar.Gender gender,
                                String expectedSingularNominative, String expectedSingularGenitive,
                                String expectedPluralNominative,
                                String expectedPluralGenitive) {
        NamedClass namedClass = new NamedClass();
        namedClass.setIndex(namedOrderNumber);
        namedClass.setRoot(root);
        namedClass.setGender(gender);

        assertEquals(expectedSingularNominative, namedOrdersAsStringRepresenter.transcript(namedClass));

        assertEquals(expectedSingularGenitive,
                     namedOrdersAsStringRepresenter.withCase(Grammar.Case.GENITIVE).transcript(namedClass));
        assertEquals(expectedPluralNominative,
                     namedOrdersAsStringRepresenter.withForm(Grammar.Form.PLURAL)
                                                   .withCase(Grammar.Case.NOMINATIVE)
                                                   .transcript(namedClass));

        assertEquals(expectedPluralGenitive,
                     namedOrdersAsStringRepresenter.withCase(Grammar.Case.GENITIVE).transcript(namedClass));
    }
}
