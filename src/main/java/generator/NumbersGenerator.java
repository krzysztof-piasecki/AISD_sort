package generator;

import sort.Heapsort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.SelectionSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersGenerator {
    private static final String RANDOM = "random";
    private static final String ASCENDING = "ascening";
    private static final String DESCENDING = "descending";
    private static final String V = "V";
    private static final String SAME = "same";

    public List<Double> getRandomNumbers(int quantity) {
        List<Double> randomList = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            randomList.add(Math.random());
        }
        return randomList;
    }

    public List<Double> getRandomAscendingNumbers(List<Double> doubleList) {
        return doubleList.stream().sorted().collect(Collectors.toList());
    }

    public List<Double> getRandomDescendingNumbers(List<Double> doubleList) {
        return doubleList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Double> getRandomSameNumbers(Integer quantity) {
        List<Double> randomList = new ArrayList<>();
        Double randomNumber = Math.random();
        for (int i = 0; i < quantity; i++) {
            randomList.add(randomNumber);
        }
        return randomList;
    }

    public List<Double> getRandomVNumber(List<Double> doubleList) {
        Double arr[] = doubleList.stream().sorted().collect(Collectors.toList()).toArray(new Double[0]);
        List<Double> finalArray = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i -= 2) {
            finalArray.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i += 2) {
            finalArray.add(arr[i]);
        }
        return finalArray;
    }

    public List<String[]> getAllRandomAndSortTime(int quantity) {
        List<String[]> data = new ArrayList<>();

        var HS = new Heapsort();
        var IS = new InsertionSort();
        var MS = new MergeSort();
        var SS = new SelectionSort();

        List<Double> randomList = getRandomNumbers(quantity);
        List<Double> randomAscendingList = getRandomAscendingNumbers(randomList);
        List<Double> randomDescendingList = getRandomDescendingNumbers(randomList);
        List<Double> randomSameNumberList = getRandomSameNumbers(quantity);
        List<Double> randomVList = getRandomVNumber(randomList);

        data.add(HS.sort(new ArrayList<>(randomList), RANDOM));
        data.add(HS.sort(new ArrayList<>(randomAscendingList), ASCENDING));
        data.add(HS.sort(new ArrayList<>(randomDescendingList), DESCENDING));
        data.add(HS.sort(new ArrayList<>(randomSameNumberList), SAME));
        data.add(HS.sort(new ArrayList<>(randomVList), V));

        data.add(IS.sort(new ArrayList<>(randomList), RANDOM));
        data.add(IS.sort(new ArrayList<>(randomAscendingList), ASCENDING));
        data.add(IS.sort(new ArrayList<>(randomDescendingList), DESCENDING));
        data.add(IS.sort(new ArrayList<>(randomSameNumberList), SAME));
        data.add(IS.sort(new ArrayList<>(randomVList), V));

        data.add(MS.sort(new ArrayList<>(randomList), RANDOM));
        data.add(MS.sort(new ArrayList<>(randomAscendingList), ASCENDING));
        data.add(MS.sort(new ArrayList<>(randomDescendingList), DESCENDING));
        data.add(MS.sort(new ArrayList<>(randomSameNumberList), SAME));
        data.add(MS.sort(new ArrayList<>(randomVList), V));

        data.add(SS.sort(new ArrayList<>(randomList), RANDOM));
        data.add(SS.sort(new ArrayList<>(randomAscendingList), ASCENDING));
        data.add(SS.sort(new ArrayList<>(randomDescendingList), DESCENDING));
        data.add(SS.sort(new ArrayList<>(randomSameNumberList), SAME));
        data.add(SS.sort(new ArrayList<>(randomVList), V));

        return data;
    }

}
