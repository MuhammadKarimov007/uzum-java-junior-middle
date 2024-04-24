package org.uzum.iggytoto.javacore_collections.homework3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLearn {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-Я+]");
        Matcher match = pattern.matcher("Убирает".toLowerCase());
        System.out.println(match.find());
    }
}
