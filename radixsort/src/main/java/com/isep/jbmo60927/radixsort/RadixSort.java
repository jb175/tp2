package com.isep.jbmo60927.radixsort;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {

    private static final int MAX_DIGIT = 10; //we use integer so we will never have value of more than 10 digits
    public static final int BASE = 10;

    private int[] integerArray;

    public RadixSort(int[] integerArray) {
        this.integerArray = RadixSort.resolve(integerArray);
    }

    public static int[] resolve(int[] integerArray) {
        int digitNumber = RadixSort.getMaxDigit(integerArray);

        ArrayList<RadixInt> toSort = new ArrayList<>();
        for (int integer : integerArray) {
            toSort.add(new RadixInt(integer));
        }

        for (int i = 0; i < digitNumber; i++) {
            Collections.sort(toSort, new RadixIntComparator(i));
        }
        
        int[] sortedList = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            sortedList[i] = toSort.get(i).getInteger();
        }

        return sortedList;
    }

    public static int getMaxDigit(int[] integerArray) {
        for (int i = 1; i < RadixSort.MAX_DIGIT; i++) {
            boolean doesDigitNeedToBeVerifyed = false;
            for (int integer : integerArray) {
                if ((integer/Math.pow(RadixSort.BASE, i)) >= 1.0)
                    doesDigitNeedToBeVerifyed = true;
            }
            if (!doesDigitNeedToBeVerifyed)
                return i;
        }
        return 0;
    }

    public int[] getIntegerArray() {
        return integerArray;
    }
}
