import exporter.ExcelExport;
import generator.NumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int quantity = 4000;
        int loops = 20;
        var exportExcel = new ExcelExport();



        exportExcel.exportToExcel(sortElementsWithLoops(loops, quantity));
    }

    public static List<String[]> sortElementsWithLoops(int loops, int quantity){
        List<String[]> allData = new ArrayList<>();
        var gen = new NumbersGenerator();
        var max = 10;
        var min = 2;

        //To obtain various outcomes, we will use random (max and min are ranges between which we want to create random number)
        var randomMultiplier = Math.random()* (max - min) + min;

        for (int i = 1; i <= loops; i++){
            allData.addAll(gen.getAllRandomAndSortTime(quantity * i * ((int) Math.floor(randomMultiplier))));
        }
        System.out.println("Sortowanie zakończone, dane zostały wyeksportowane do excela");
        return allData;
    }
}


