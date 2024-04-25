package org.uzum.iggytoto.javacore_streams;

import org.uzum.iggytoto.javacore_streams.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс для реализации домашнего задания номер три, часть 2.
 */
public class Homework3_2 {

    /**
     * Реализовать метод при помощи {@link java.util.stream.Stream} который:
     * - группирует заданых персон по возрасту
     * - фильтрует по минимальному возрасту
     * - Убирает дубликаты персон по имени
     * @param persons - заданный список персон
     * @param minimalAgeFilter - указанный минимальный возраст
     * @param removeDupes - флаг отвечающий за исключение дубликатов из результата
     * @return словарь где ключ хобби а значение лист персон с этим хобби
     */
    public Map<Integer, List<Person>> groupByAge(List<Person> persons, int minimalAgeFilter,  boolean removeDupes) {
        if (persons == null) {
            System.out.println("список людей null");
            return null;
        }
        if (minimalAgeFilter < 0) {
            System.out.println("возраст не может быть отрицательным числом");
            return null;
        }

        if (removeDupes) {
            return persons.stream()
                    .filter(person -> person.getAge() >= minimalAgeFilter)
                    .distinct()
                    .collect(Collectors.groupingBy(Person::getAge));
        } else {
            return persons.stream()
                    .filter(person -> person.getAge() >= minimalAgeFilter)
                    .collect(Collectors.groupingBy(Person::getAge));
        }

    }
}
