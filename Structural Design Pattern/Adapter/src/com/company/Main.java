package com.company;

import com.company.adapters.FileAdapter;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculation cal = new Calculation();
        File spaceFile = new File("space.txt");
        File tildeFile = new File("tilde.txt");
        Double sum = cal.calculateSum(spaceFile);
        System.out.printf("Result from space file: %.4f\n", sum);
        File adaptedFile = FileAdapter.adaptFile(tildeFile, "~");
        sum = cal.calculateSum(adaptedFile);
        System.out.printf("Result from tilde file: %.4f\n",sum);
    }
}
