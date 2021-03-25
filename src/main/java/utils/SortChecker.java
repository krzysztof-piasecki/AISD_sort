package utils;

import java.util.Iterator;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

public class SortChecker {
    public static boolean isSorted(List<Double> listOfDoubles) {
        if (isEmpty(listOfDoubles) || listOfDoubles.size() == 1) {
            return true;
        }

        Iterator<Double> iter = listOfDoubles.iterator();
        Double current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}
