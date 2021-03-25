package sort;

import utils.SortChecker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertionSort {
    public String[] sort(List<Double> list, String arrayType){
        Double arr [] = list.toArray(new Double[0]);
        String info [] = new String[4];
        int n = arr.length;

        long start = System.currentTimeMillis();
        for (int i = 1; i < n; ++i) {
            Double key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long stop = System.currentTimeMillis();

        Map<String,Long> data = new HashMap<>();
        data.put("IS" + n, stop - start);

//        System.out.println("IS is it sorted correctly ?" + SortChecker.isSorted(Arrays.asList(arr)));
        info[0] = "IS";
        info[1] = arrayType;
        info[2] = n + "";
        info[3] = (stop - start) + "";
        return info;
    }
}
