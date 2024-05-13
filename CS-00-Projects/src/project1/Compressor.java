package project1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Compressor {
    public static void main(String[] args) {
        try {
            new Compressor().compress("data/test.txt", "not done");
        } catch (IOException e) {
            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            System.err.println("There was an error:" + e.getLocalizedMessage());
        }
    }

    public void compress(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
        String line = "";
        while (line != null) {
            line = reader.readLine();
            System.out.println(line);
        }
    } catch (FileNotFoundException e) {
        System.out.println(e.getLocalizedMessage());
    }
  }
}
