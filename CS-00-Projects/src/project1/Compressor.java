package project1;

import java.io.*;

public class Compressor {
    private static int code = 1; // Starting from 1 for readability

    // public static void main(String[] args) {
    //     try {
    //         new Compressor().compress("data/test.txt", "not done");
    //     } catch (IOException e) {
    //         System.err.println("There was an error:" + e.getLocalizedMessage());
    //     }
    // }

    public void compress(String inputFile, String compressedFile) throws IOException {
        // Convert the String data to a ByteArrayInputStream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputFile.getBytes());
        // Wrap the ByteArrayInputStream with an InputStreamReader to convert bytes to characters
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        // Finally, wrap the InputStreamReader with a BufferedReader
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = "";
        StringBuilder compressed = new StringBuilder();
        while (line != null) {
            line = reader.readLine();
            // Simple compression logic: For each unique line, assign a unique code.
            compressed.append(code++).append(": ").append(line).append(System.lineSeparator());
        }
        // Write compressed data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(compressedFile))) {
            writer.write(compressed.toString());
        }
    }
  }

