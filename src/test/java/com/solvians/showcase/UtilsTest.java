package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @Test
    public void calculateSum(){
        String output = Utils.convertLettersToNumbers("DE123456789");
        assertEquals(54, Utils.calculateSum(output));
    }

    @Test
    public void convertLettersToNumbers(){
        assertEquals("10",Utils.convertLettersToNumbers("A"));
        assertEquals("11",Utils.convertLettersToNumbers("B"));
        assertEquals("35",Utils.convertLettersToNumbers("Z"));
    }

    @Test
    public void calculateCheckDigit(){
        assertEquals(6, Utils.calculateCheckDigit("DE123456789"));
    }

    @Test
    public void calculateCheckDigitReturnsAlwaysSingleDigit(){
        int result = Utils.calculateCheckDigit("DE123456789");
        assertTrue(result >=0 && result<=9);
    }
}
