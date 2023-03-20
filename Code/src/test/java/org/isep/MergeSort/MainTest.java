package org.isep.MergeSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void mergeTest() {
        int[] arrayExpected = new int[]{1,2,3,4};
        int[] array = Main.merge(new int[]{3,4,1,2},0,2,3);
        assertEquals(Arrays.toString(arrayExpected),Arrays.toString(array));
    }

    @Test
    public void mergeSortTest() {
        int[] arrayExpected = new int[]{1,2,3,4};
        int[] array = Main.mergeSort(new int[]{4,2,1,3});
        assertEquals(Arrays.toString(arrayExpected),Arrays.toString(array));
    }

}