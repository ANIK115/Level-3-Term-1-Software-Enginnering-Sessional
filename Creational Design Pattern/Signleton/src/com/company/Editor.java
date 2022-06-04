package com.company;

import com.company.fonts.Fonts;
import com.company.parsers.Parser;

import java.awt.*;

public class Editor {
    private String environment;
    Fonts font;
    Parser parser;

    public Editor(Fonts font, Parser parser) {
        this.font = font;
        this.parser = parser;
        this.environment = "windows";
    }

    public void parsingMethod()
    {
        System.out.println("Font: "+font.getFont());
        System.out.println("Environment: "+environment);
        System.out.println("Parser: "+parser.getParserName());
    }
}
