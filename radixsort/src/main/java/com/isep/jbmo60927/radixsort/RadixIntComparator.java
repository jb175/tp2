package com.isep.jbmo60927.radixsort;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RadixIntComparator implements Comparator<RadixInt> {

    private static final Logger LOGGER = Logger.getLogger(RadixIntComparator.class.getName());
    private int digitToCompare;

    public RadixIntComparator(int digitToCompare) {
        LOGGER.setLevel(Level.INFO);
        this.digitToCompare = digitToCompare;
    }

    @Override
    public int compare(RadixInt arg0, RadixInt arg1) {
        int digit0 = arg0.getDigit(digitToCompare);
        int digit1 = arg1.getDigit(digitToCompare);
        if (digit0 >= 0 && digit1 >= 0 && digitToCompare >= 0) {
            if (arg0.getDigit(digitToCompare) == arg1.getDigit(digitToCompare))
                return 0;
            if (arg0.getDigit(digitToCompare) > arg1.getDigit(digitToCompare))
                return 1;
            else
                return -1;
        } else {
            LOGGER.log(Level.SEVERE, "Error\nWe try to access a digit lower to 0");
            System.exit(0);
            return 0;
        }

    }
    
}
