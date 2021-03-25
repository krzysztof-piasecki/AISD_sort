import exporter.ExcelExport;
import generator.NumbersGenerator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int quantity = 0;
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


