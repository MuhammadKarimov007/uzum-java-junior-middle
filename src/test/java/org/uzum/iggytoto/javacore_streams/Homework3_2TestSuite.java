package org.uzum.iggytoto.javacore_streams;

import org.junit.jupiter.api.Test;
import org.uzum.iggytoto.javacore_streams.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Homework3_2TestSuite {

    @Test
    public void test() {
        Person person1 = new Person("Mark", 25,List.of(), Map.of());
        Person person2 = new Person("Scott", 30,List.of(), Map.of());
        Person person3 = new Person("Tom", 25,List.of(), Map.of());
        Person person4 = new Person("Mark", 25,List.of(), Map.of());
        Person person5 = new Person("Bob", 18,List.of(), Map.of());
        Person person6 = new Person("Mark", 9,List.of(), Map.of());
        Person person7 = new Person("Masha", 12,List.of(), Map.of());
        Person person8 = new Person("Mark", 45,List.of(), Map.of());
        Person person9 = new Person("Tim", 19,List.of(), Map.of());
       Person person10 = new Person("Scott", 30,List.of(), Map.of());

        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10);
        List<Person> nullPerson = null;

        Homework3_2 processor = new Homework3_2();

        Map<Integer, List<Person>> nullResult = processor.groupByAge(nullPerson, 12, true);
        assertNull(nullResult);

        // Test grouping by age without filters
        Map<Integer, List<Person>> result = processor.groupByAge(persons, 0, false);
        assertEquals(7, result.size());
        assertTrue(result.containsKey(25));
        assertTrue(result.containsKey(30));
        assertEquals(3, result.get(25).size());
        assertEquals(2, result.get(30).size());

        // Test grouping by age with minimal age filter
        result = processor.groupByAge(persons, 26, false);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(30));
        assertEquals(2, result.get(30).size());

        // Test grouping by age with removing duplicates
        persons = List.of(person1,person1,person2,person3, person4,
                person5, person7, person8, person9, person10,
                person5, person5);
        result = processor.groupByAge(persons, 0, true);
        assertEquals(5, result.size());
        assertTrue(result.containsKey(25));
        assertTrue(result.containsKey(30));
        assertEquals(2, result.get(25).size());
        assertEquals(1, result.get(30).size());
    }


}