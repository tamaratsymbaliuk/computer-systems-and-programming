package project1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Compressor {
    private static int code = 1; // Starting from 1 for readability
    private Map<String, Integer> wordToCodeMap = new HashMap<>(); // Mapping of words to codes

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
        // Add the mapping to the compressed file content
        StringBuilder compressed = new StringBuilder();

        // Add the mapping to the compressed file content
        StringBuilder mapping = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Split line into words
            for (String word : words) {
                if (!wordToCodeMap.containsKey(word)) {
                    wordToCodeMap.put(word, code++);
                }
                compressed.append(wordToCodeMap.get(word)).append(" ");
            }
            compressed.append(System.lineSeparator());
        }

        // Write the mapping and compressed data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(compressedFile))) {
            writer.write("Mapping:\n");
            for (Map.Entry<String, Integer> entry : wordToCodeMap.entrySet()) {
                writer.write(entry.getValue() + ": " + entry.getKey());
                writer.newLine();
            }
            writer.write("Compressed Data:\n");
            writer.write(compressed.toString());
        }
    }
}

