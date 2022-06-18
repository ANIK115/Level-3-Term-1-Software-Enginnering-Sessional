package com.company;

import com.company.adapters.Adapter;
import com.company.adapters.TildeSeparation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Calculation {

    public double calculateSum(File file) throws FileNotFoundException {
        double sum = 0.0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            for(int i=0; i<parts.length; i++)
                sum += Double.parseDouble(parts[i]);
        }

        return sum;
    }
}
