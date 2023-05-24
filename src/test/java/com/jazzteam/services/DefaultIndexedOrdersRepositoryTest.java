package com.jazzteam.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.jazzteam.factories.MyNamedClassFactoryRepository;
import com.jazzteam.interfaces.NamedClassRepository;
import com.jazzteam.models.Grammar;
import com.jazzteam.models.NamedClass;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultIndexedOrdersRepositoryTest {
    static NamedClassRepository namedClassRepository;

    @BeforeAll
    static void init() {
        namedClassRepository = new MyNamedClassFactoryRepository().create();
    }

    static Stream<Arguments> namedOrders() {
        return Stream.of(
                Arguments.of(0 , Grammar.Gender.MALE, ""),
                Arguments.of(1 , Grammar.Gender.FEMALE, "тысяч"),
                Arguments.of(2 , Grammar.Gender.MALE, "миллион"),
                Arguments.of(3 , Grammar.Gender.MALE, "миллиард"),
                Arguments.of(4 , Grammar.Gender.MALE, "триллион"),
                Arguments.of(5 , Grammar.Gender.MALE, "квадриллион"),
                Arguments.of(6 , Grammar.Gender.MALE, "квинтиллион"),
                Arguments.of(7 , Grammar.Gender.MALE, "секстиллион"),
                Arguments.of(8 , Grammar.Gender.MALE, "септиллион"),
                Arguments.of(9 , Grammar.Gender.MALE, "октиллион"),
                Arguments.of(10, Grammar.Gender.MALE, "нониллион"),
                Arguments.of(11, Grammar.Gender.MALE, "дециллион"),
                Arguments.of(12, Grammar.Gender.MALE, "ундециллион"),
                Arguments.of(13, Grammar.Gender.MALE, "додециллион"),
                Arguments.of(14, Grammar.Gender.MALE, "тредециллион"),
                Arguments.of(15, Grammar.Gender.MALE, "кваттуордециллион"),
                Arguments.of(16, Grammar.Gender.MALE, "квиндециллион"),
                Arguments.of(17, Grammar.Gender.MALE, "сексдециллион"),
                Arguments.of(18, Grammar.Gender.MALE, "септемдециллион"),
                Arguments.of(19, Grammar.Gender.MALE, "октодециллион"),
                Arguments.of(20, Grammar.Gender.MALE, "новемдециллион"),
                Arguments.of(21, Grammar.Gender.MALE, "вигинтиллион"),
                Arguments.of(22, Grammar.Gender.MALE, "унвигинтиллион"),
                Arguments.of(23, Grammar.Gender.MALE, "дуовигинтиллион"),
                Arguments.of(24, Grammar.Gender.MALE, "тревигинтиллион"),
                Arguments.of(25, Grammar.Gender.MALE, "кватуорвигинтиллион"),
                Arguments.of(26, Grammar.Gender.MALE, "квинвигинтиллион"),
                Arguments.of(27, Grammar.Gender.MALE, "сексвигинтиллион"),
                Arguments.of(28, Grammar.Gender.MALE, "септенвигинтиллион"),
                Arguments.of(29, Grammar.Gender.MALE, "октовигинтиллион"),
                Arguments.of(30, Grammar.Gender.MALE, "новемвигинтиллион"),
                Arguments.of(31, Grammar.Gender.MALE, "тригинтиллион"),
                Arguments.of(32, Grammar.Gender.MALE, "унтригинтиллион"),
                Arguments.of(33, Grammar.Gender.MALE, "дуотригинтиллион"),
                Arguments.of(34, Grammar.Gender.MALE, "третригинтиллион"),
                Arguments.of(35, Grammar.Gender.MALE, "кватортригинтиллион"),
                Arguments.of(36, Grammar.Gender.MALE, "квинтригинтиллион"),
                Arguments.of(37, Grammar.Gender.MALE, "секстригинтиллион")
        );
    }

    @Test
    @DisplayName("Has 38 named orders")
    void hasThirtyEightRecords() {
        assertEquals(38, namedClassRepository.getItems().size());
    }

    @ParameterizedTest
    @DisplayName("Returns NamedOrder by named order number, with default gender, form and case")
    @MethodSource("namedOrders")
    void namedOrdersByNumber(int namedOrderNumber, Grammar.Gender expectedGender, String expectedRoot) {
        NamedClass namedClass = namedClassRepository.getByNumber(namedOrderNumber);
        assertEquals(expectedGender, namedClass.getGender());
        assertEquals(expectedRoot, namedClass.getRoot());
    }
}
