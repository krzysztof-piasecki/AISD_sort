package sort;

import utils.SortChecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSort {
    public String[] sort(List<Double> list, String arrayType){
        Double arr [] = list.toArray(new Double[0]);
        String info [] = new String[4];
        int n = arr.length;

        long start = System.currentTimeMillis();

        mergeSort(arr,n);

        long stop = System.currentTimeMillis();

//        System.out.println("MS is it sorted correctly ?" + SortChecker.isSorted(Arrays.asList(arr)));
        info[0] = "MS";
        info[1] = arrayType;
        info[2] = n + "";
        info[3] = (stop - start) + "";
        return info;
    }
    public void mergeSort(Double[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Double[] l = new Double[mid];
        Double[] r = new Double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            Double[] a, Double[] l, Double[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
