package com.jazzteam.builders;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.jazzteam.interfaces.DigitBuilder;
import com.jazzteam.models.Grammar;
import com.jazzteam.models.Digit;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyDigitBuilderTest {
    private static DigitBuilder digitBuilder;

    @BeforeAll
    static void setUp() {
        digitBuilder = new MyDigitBuilder();
    }

    @AfterAll
    static void setDown() {
        digitBuilder.reset();
    }

    static Stream<Arguments> digitParams() {
        return Stream.of(
                Arguments.of(Grammar.Case.NOMINATIVE, Grammar.Form.SINGULAR, 1, "1"),
                Arguments.of(Grammar.Case.GENITIVE, Grammar.Form.PLURAL, 2, "11"),
                Arguments.of(Grammar.Case.NOMINATIVE, Grammar.Form.SINGULAR, 0, "12"),
                Arguments.of(Grammar.Case.GENITIVE, Grammar.Form.PLURAL, 1, "0")
        );
    }

    @ParameterizedTest
    @DisplayName("Builds digit from params without gender")
    @MethodSource("digitParams")
    void createDigitByParams(Grammar.Case aCase, Grammar.Form form, int positionInClass, String expectedDigit) {
        Digit digit =
                digitBuilder.withForm(form)
                        .withPositionInClass(positionInClass)
                        .withCase(aCase)
                        .withNumber(expectedDigit)
                        .getResult();
        assertEquals(aCase, digit.getCase());
        assertEquals(form, digit.getForm());
        assertEquals(positionInClass, digit.getPositionInClass());
        assertEquals(expectedDigit, digit.getNumber());
    }
}