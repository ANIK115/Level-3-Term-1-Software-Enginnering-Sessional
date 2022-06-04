package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EditorConnection ec = EditorConnection.getEditorConnection("hello.c");
        Editor editor;
        if(ec.getEditor()==null)
        {
            System.out.println("Can't instantiate editor! ");
            return;
        }
        editor = ec.getEditor();
        editor.parsingMethod();
        ec = EditorConnection.getEditorConnection("hello.py");
        EditorConnection.turnOffPreviousConnection();
        ec = EditorConnection.getEditorConnection("hello.py");
        editor = ec.getEditor();
        editor.parsingMethod();
    }
}
