package com.company;

import com.company.fonts.Consolas;
import com.company.fonts.CourierNew;
import com.company.fonts.Monaco;
import com.company.parsers.CParser;
import com.company.parsers.CppParser;
import com.company.parsers.PythonParser;

public class EditorConnection {
    private Editor editor;
    private static EditorConnection editorInstance = null;
    private EditorConnection(Editor editor)
    {
        this.editor = editor;
    }
    public static EditorConnection getEditorConnection(String fileName)
    {
        if(editorInstance == null) {
            Editor e;
            String[] parts = fileName.split("\\.");
            if (parts[1].equals("c")) {
                e = new Editor(new CourierNew(), new CParser());
            } else if (parts[1].equals("cpp")) {
                e = new Editor(new Monaco(), new CppParser());
            } else if (parts[1].equals("py")) {
                e = new Editor(new Consolas(), new PythonParser());
            } else {
                e = null;
            }
            editorInstance = new EditorConnection(e);
        }else
        {
            System.out.println("Editor is already used for some language.");
        }
        return editorInstance;
    }
    public static void turnOffPreviousConnection()
    {
        if(editorInstance != null)
        {
            editorInstance = null;
            System.out.println("Turned off previous editor connection");
        }

    }

    public Editor getEditor() {
        return editor;
    }
}
