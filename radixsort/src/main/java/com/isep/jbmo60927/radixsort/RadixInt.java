package com.isep.jbmo60927.radixsort;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RadixInt {

    private static final Logger LOGGER = Logger.getLogger(RadixInt.class.getName());
    
    private int integer;

    public RadixInt(int integer) {
        LOGGER.setLevel(Level.INFO);
        this.integer = integer;
    }

    public int getDigit(int digit) {
        if (digit >= 0)
            return (int) ((integer/Math.pow(RadixSort.BASE, digit))%RadixSort.BASE);
        return -1;
    }

    public int getInteger() {
        return this.integer;
    }
}
