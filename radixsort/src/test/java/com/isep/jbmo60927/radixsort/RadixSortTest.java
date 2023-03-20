package com.isep.jbmo60927.radixsort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadixSortTest {
    @Test
    public void testGetMaxDigit() {
        assertEquals(2, RadixSort.getMaxDigit(new int[] {0, 14, 6, 7}));
        assertEquals(3, RadixSort.getMaxDigit(new int[] {100, 14, 6, 7}));
        assertEquals(5, RadixSort.getMaxDigit(new int[] {10000, 14, 6, 7}));
    }

    @Test
    public void testResolve() {
        assertArrayEquals(new int[] {2, 6, 31, 37, 87}, RadixSort.resolve(new int[] {37, 6, 87, 2, 31}));
    }
}
