package com.solvians.showcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsinGeneratorTest {

    private IsinGenerator isinGenerator;

    @BeforeEach
    public void setUp(){
        isinGenerator = new IsinGenerator();
    }

    @Test
    public void generate12CharsIsin(){

        assertEquals(12, isinGenerator.generate().length());
    }

    @Test
    public void isinStartsWithTwoLetters(){
        String isin = isinGenerator.generate();
        assertTrue(Character.isLetter(isin.charAt(0)));
        assertTrue(Character.isLetter(isin.charAt(1)));
    }

    @Test
    public void isinLastCharIsDigit(){
        String isin = isinGenerator.generate();
        assertTrue(Character.isDigit(isin.charAt(11)));
    }


}
