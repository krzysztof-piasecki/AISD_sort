package sort;

import utils.SortChecker;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public String[] sort(List<Double> list, String arrayType){
        Double arr [] = list.toArray(new Double[0]);
        String info [] = new String[4];

        int n = arr.length;

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            double smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        long stop = System.currentTimeMillis();

//        System.out.println("SS is it sorted correctly ?" + SortChecker.isSorted(Arrays.asList(arr)));
        info[0] = "SS";
        info[1] = arrayType;
        info[2] = n + "";
        info[3] = (stop - start) + "";
        return info;
    }
}
