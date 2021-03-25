package sort;

import utils.SortChecker;

import java.lang.reflect.Array;
import java.util.*;

public class Heapsort {

    public String[] sort(List<Double> list, String arrayType) {
        Double arr[] = list.toArray(new Double[0]);
        String info [] = new String[4];

        int n = arr.length;

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            double smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        long stop = System.currentTimeMillis();

//        System.out.println("HS is it sorted correctly ?" + SortChecker.isSorted(Arrays.asList(arr)));
        info[0] = "HS";
        info[1] = arrayType;
        info[2] = n + "";
        info[3] = (stop - start) + "";
        return info;
    }

    public void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
