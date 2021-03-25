import exporter.ExcelExport;
import generator.NumbersGenerator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TO GET DATA TO EXCEL YOU NEED TO CHANGE quantity and loops value to your chosen number (it has to be absolute positive number)

        //it is a number of elements that have to be sorted
        int quantity = 0;
        //it is a number of times the quantity will be multiply by
        // lets say quantity starts at 10 and loops are 3
        //the first number of elements will be 10, following one will be 20
        //and the final will be 30 etc.
        int loops = 0;
        var exportExcel = new ExcelExport();


        exportExcel.exportToExcel(sortElementsWithLoops(loops, quantity));
    }

    public static List<String[]> sortElementsWithLoops(int loops, int quantity) {
        List<String[]> allData = new ArrayList<>();
        var gen = new NumbersGenerator();

        for (int i = 1; i <= loops; i++) {
            allData.addAll(gen.getAllRandomAndSortTime(quantity * i));
            double percentage = ((double)i / (double)loops) * 100;
            System.out.println("Loading " + new DecimalFormat("#,##0").format(percentage) + "%");
        }
        System.out.println("Sortowanie zakończone, dane zostały wyeksportowane do excela");
        return allData;
    }
}


