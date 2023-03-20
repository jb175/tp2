package com.isep.jbmo60927.radixsort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadixIntTest {
    @Test
    public void testGetDigit() {
        RadixInt radixInt = new RadixInt(43672);
        assertEquals(2, radixInt.getDigit(0));
        assertEquals(7, radixInt.getDigit(1));
        assertEquals(6, radixInt.getDigit(2));
        assertEquals(3, radixInt.getDigit(3));
        assertEquals(4, radixInt.getDigit(4));
        assertEquals(0, radixInt.getDigit(5));
        assertEquals(-1, radixInt.getDigit(-1));
    }
}
