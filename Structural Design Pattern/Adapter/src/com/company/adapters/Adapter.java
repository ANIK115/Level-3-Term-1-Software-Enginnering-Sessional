package com.company.adapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Adapter {
    public File adaptFile(File file) throws IOException;
}
