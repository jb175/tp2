package com.isep.jbmo60927.radixsort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadixIntComparatorTest {
    @Test
    public void testCompare() {
        RadixInt[] integer = new RadixInt[] {
            new RadixInt(-1),
            new RadixInt(0),
            new RadixInt(7),
            new RadixInt(14),
            new RadixInt(32),
            new RadixInt(727)
        };

        RadixIntComparator[] comparators = new RadixIntComparator[] {
            new RadixIntComparator(0),
            new RadixIntComparator(1),
            new RadixIntComparator(2),
            new RadixIntComparator(3),
            new RadixIntComparator(-1)
        };

        assertEquals(1, comparators[0].compare(integer[2], integer[1]));
        assertEquals(-1, comparators[0].compare(integer[1], integer[2]));
        assertEquals(0, comparators[0].compare(integer[1], integer[1]));
        assertEquals(0, comparators[0].compare(integer[2], integer[5]));
        assertEquals(-1, comparators[1].compare(integer[3], integer[4]));
        assertEquals(1, comparators[1].compare(integer[4], integer[5]));
        assertEquals(-1, comparators[1].compare(integer[3], integer[5]));
        assertEquals(-1, comparators[2].compare(integer[4], integer[5]));
        assertEquals(0, comparators[3].compare(integer[4], integer[5]));
    }
}
