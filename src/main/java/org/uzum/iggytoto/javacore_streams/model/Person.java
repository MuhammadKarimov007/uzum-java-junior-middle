/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package org.uzum.iggytoto.javacore_streams.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Person
{
    private String name;
    private int age;
    private List<String> hobbies;
    private Map<String, String> family;

    public Person()
    {
        setHobbies(new ArrayList<>());
        setFamily(new HashMap<>());
    }

    public Person(String name, int age, List<String> hobbies, Map<String, String> family)
    {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.family = family;
    }


    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if(!hobbies.isEmpty()) System.out.println("Hobbies: " + hobbies.toString());
        if(!family.isEmpty()) System.out.println("Family: " + family.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
