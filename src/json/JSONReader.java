package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONObject;

public class JSONReader
{
    public static JSONObject readJSONFile(File file)
    {
        String json = "", line;
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            try {
                while((line = reader.readLine()) != null)
                {
                    json += line;
                }
            } catch(IOException readingException)
            {
                // do nothing
            }
        } catch(FileNotFoundException fileNotFound) 
        {
            System.err.println("The file " + file.getName() + " was not found");
            return null;
        }

        return new JSONObject(json);
    }
}