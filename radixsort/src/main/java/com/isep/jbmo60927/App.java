package com.isep.jbmo60927;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.isep.jbmo60927.logger.MyLogger;
import com.isep.jbmo60927.radixsort.RadixSort;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private static final int[] listToSort = new int[] {
        170, 45, 75, 90, 2, 802, 2, 66
    };

    public App() {
        LOGGER.setLevel(Level.INFO);
        RadixSort radixSort = new RadixSort(App.listToSort);
        int[] sortedList = radixSort.getIntegerArray();
        for (int i = 0; i < sortedList.length; i++)
            if (LOGGER.isLoggable(Level.INFO))
                LOGGER.log(Level.INFO, String.format("%d\\%d", i, sortedList[i]));
    }
    
    public static void main(String[] args) throws IOException {
        MyLogger.setup(); //setup the logger for the app
        new App();
    }
}
