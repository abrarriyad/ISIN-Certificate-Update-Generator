package com.solvians.showcase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CertificateUpdateTest {

    private  CertificateUpdate certificateUpdate;

    @BeforeEach
    public void setUp(){
        certificateUpdate = new CertificateUpdate();
    }

    @Test
    public void has12CharactersInin() throws Exception {
        String [] fields = certificateUpdate.call().split(",");
        assertEquals(12, fields[1].length());
    }

    @Test
    public void bidPriceIsWithinRange() throws Exception {
        String [] fields = certificateUpdate.call().split(",");
        int bidSize = Integer.parseInt(fields[3]);
        assertTrue(bidSize >= 1000 && bidSize <= 5000);
    }

    @Test
    public void askPriceIsWithinRange() throws Exception {
        String [] fields = certificateUpdate.call().split(",");
        int askPrice = Integer.parseInt(fields[5]);
        assertTrue(askPrice >= 1000 && askPrice <= 10000);
    }


}
