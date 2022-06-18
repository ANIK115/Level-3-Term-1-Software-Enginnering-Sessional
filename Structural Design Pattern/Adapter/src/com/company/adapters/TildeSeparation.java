package com.company.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TildeSeparation implements Adapter
{
    @Override
    public File adaptFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        File newFile = new File("adaptedFile.txt");
        FileWriter fileWriter = new FileWriter(newFile);
        while(scanner.hasNextLine())
        {
            String adaptedFile = "";
            String line = scanner.nextLine();
            String[] parts = line.split("~");
            for(int i=0; i< parts.length; i++)
            {
                adaptedFile+= parts[i];
                if(i < parts.length-1)
                    adaptedFile+= " ";

            }
            fileWriter.write(adaptedFile+"\n");
        }

        fileWriter.close();
        return newFile;

    }
}
