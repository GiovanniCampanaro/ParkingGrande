package it.Itsrizzoli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {
    static String readTextFrom(String fname) {

        InputStream is;
        is = Pad.class.getClassLoader().getResourceAsStream(fname);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String fileAsString = "";

        String line = null;

        while (true) {
            try {
                line = buf.readLine();
                if (line == null)
                    break;
                fileAsString+=line+"\n";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileAsString;
    }
}
