package com.company.adapters;

import java.io.File;
import java.io.IOException;

public class FileAdapter {
    public static File adaptFile(File file, String separationType) throws IOException {
        if(separationType.equalsIgnoreCase(" "))
        {
            return file;
        }else if(separationType.equalsIgnoreCase("~"))
        {
            Adapter adapter = new TildeSeparation();
            File adaptedFile = adapter.adaptFile(file);
            return adaptedFile;
        }else
        {
            System.out.println("Unknown separation! Cannot process file. Returning null");
            return null;
        }
    }
}
