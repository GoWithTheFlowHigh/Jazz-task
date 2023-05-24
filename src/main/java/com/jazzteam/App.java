package com.jazzteam;

import com.jazzteam.builders.MyTripleSequenceAsWordRepresenterBuilder;
import com.jazzteam.builders.MyTripleSequenceFactoryBuilder;
import com.jazzteam.interfaces.TripleSequenceAsWordRepresenter;
import com.jazzteam.interfaces.TripleSequenceFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TripleSequenceFactory tripleSequenceFactory = new MyTripleSequenceFactoryBuilder().getResult();
        TripleSequenceAsWordRepresenter tripleSequenceAsWordRepresenter =
                new MyTripleSequenceAsWordRepresenterBuilder().getResult();

        List<Boolean> testsResult = new LinkedList<>();
        List<String> input = new LinkedList<>();
        List<String> actual = new LinkedList<>();
        List<String> expected = new LinkedList<>();
        System.out.flush();
        System.out.println("Введите число тестов: ");
        int testsCount = Integer.parseInt(sc.nextLine());
        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            System.out.println(" Введите число в цифровом виде: ");
            String number = sc.nextLine();
            System.out.println(" Введите строковое представление этого числа: ");
            String expectedWordsRepresentationOfNumber = sc.nextLine();

            tripleSequenceFactory.setSource(number);

            String actualWordsRepresentationOfNumber =
                    tripleSequenceAsWordRepresenter.transcript(tripleSequenceFactory.create());
            expected.add(expectedWordsRepresentationOfNumber);

            input.add(number);
            actual.add(actualWordsRepresentationOfNumber);
            testsResult.add(actualWordsRepresentationOfNumber.equals(expectedWordsRepresentationOfNumber));
        });
        System.out.flush();
        IntStream.range(0, testsCount).forEach(dataSetNumber -> {
            boolean testResult = testsResult.get(dataSetNumber);
            System.out.printf("Тест #%d результат: %s%n",
                    dataSetNumber,
                    testResult ? "успешно завершен" : "провален");
            if (!testResult) {
                System.out.printf("\tИсходное число: %s%n", input.get(dataSetNumber));
                System.out.printf("\tТекущий результат: %s%n", expected.get(dataSetNumber));
                System.out.printf("\tОжидаемый результат: %s%n", actual.get(dataSetNumber));
            }
        });
    }
}

