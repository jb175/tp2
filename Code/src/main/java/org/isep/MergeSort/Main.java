package org.isep.MergeSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{8,5,2,4,7,6,3,1};
        System.out.println("An array : " + Arrays.toString(array));
        int[] mergeSortedArray = mergeSort(array);
        System.out.println("The merge sorted array : " + Arrays.toString(mergeSortedArray));
    }

    public static int[] mergeSort(int[] array) {
        int lengthOfArray = array.length;
        int middle;
        int end;
        for (int i = 1; i < lengthOfArray; i = 2*i){
            for (int start = 0; start < lengthOfArray; start += 2*i) {
                end = start + (2*i - 1);
                middle = (start + end + 1) / 2;
                merge(array, start, middle, end);
            }
        }
        return array;
    }

    public static int[] merge(int[] array, int start, int middle, int end) {
        int lengthOfLeftArray = middle - start;
        int[] leftArray = new int[lengthOfLeftArray];
        System.arraycopy(array, start, leftArray, 0, lengthOfLeftArray);
        int lengthOfRightArray = end - middle + 1;
        int[] rightArray = new int[lengthOfRightArray];
        System.arraycopy(array, middle, rightArray, 0, lengthOfRightArray);
        int i = 0;
        int j = 0;
        int k = start;
        while (i < lengthOfLeftArray && j < lengthOfRightArray) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        for (int a = i; a < lengthOfLeftArray; a++) {
            array[k] = leftArray[a];
            k++;
        }
        for (int b = j; b < lengthOfRightArray; b++) {
            array[k] = rightArray[b];
            k++;
        }
        return array;
    }

}