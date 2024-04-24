package org.uzum.iggytoto.javacore_collections.homework3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.HashMap;

public class Homework3_1TestSuite {

    @Test
    public void testCountWords() {
        Homework3_1 wordCounter = new Homework3_1();


        Map<String, Integer> emptyResult = wordCounter.countWords("");
        assertTrue(emptyResult.isEmpty(), "Пустой ввод должен возвращать пустой объект");


        Map<String, Integer> singleWordResult = wordCounter.countWords("Книги хорошие");
        assertEquals(2, singleWordResult.size(), "должно быть 2");
        assertFalse(singleWordResult.containsKey("Книги"), "все слова пишутся с маленькой буквы");
        assertEquals(1, singleWordResult.get("хорошие"), "слово 'хорошие' должно быть отображено");


        Map<String, Integer> multipleWordsResult = wordCounter.countWords("Java, Java — отличный язык, отличный язык");
        assertEquals(3, multipleWordsResult.size(), "результат должен содержать 3 слова");
        assertEquals(2, multipleWordsResult.get("java"), "слово java должно встречаться дважды");
        assertEquals(2, multipleWordsResult.get("язык"), "слово язык должно встречаться дважды");
        assertEquals(2, multipleWordsResult.get("отличный"), "слово отличный должно встречаться дважды");
        assertFalse(multipleWordsResult.containsKey(","), "Знаки препинания не следует считать словами");


        Map<String, Integer> punctuationResult = wordCounter.countWords("Это проверочное предложение, с некоторой пунктуацией...!");
        assertEquals(6, punctuationResult.size(), "Результат должен содержать шесть слов");
        assertEquals(1, punctuationResult.get("это"));
        assertEquals(1, punctuationResult.get("проверочное"));
        assertEquals(1, punctuationResult.get("предложение"));
        assertEquals(1, punctuationResult.get("с"));
        assertEquals(1, punctuationResult.get("некоторой"));
        assertEquals(1, punctuationResult.get("пунктуацией"));
        assertFalse(punctuationResult.containsKey(","));
        assertFalse(punctuationResult.containsKey("!"));
        assertFalse(punctuationResult.containsKey("..."));
    }
}

