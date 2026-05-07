package com.solvians.showcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
