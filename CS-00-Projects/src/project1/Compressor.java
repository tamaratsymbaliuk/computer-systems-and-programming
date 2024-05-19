package project1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Compressor {
    private static int code = 1; // Starting from 1 for readability
    private Map<String, Integer> wordToCodeMap = new HashMap<>(); // Mapping of words to codes

    public void compress(String inputFile, String compressedFile) throws IOException {
        // Convert the String data to a ByteArrayInputStream
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputFile.getBytes());
        // Wrap the ByteArrayInputStream with an InputStreamReader to convert bytes to characters
        // to read characters instead of bytes.
        // An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset.
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        // Finally, wrap the InputStreamReader with a BufferedReader
        // BR reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
        // https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line;
        // Add the mapping to the compressed file content
        StringBuilder compressed = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Split line into words and store in words array
            for (String word : words) {
                word.trim();
                if (!wordToCodeMap.containsKey(word)) {
                    wordToCodeMap.put(word, code++);
                }
                compressed.append(wordToCodeMap.get(word)).append(" ");
            }
            // A newline character is appended at the end of each line.
            compressed.append(System.lineSeparator());
        }

        // Write the compressed data to the file,
        // BufferedWriter writes text to a character-output stream
        // https://docs.oracle.com/javase/8/docs/api/java/io/BufferedWriter.html
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

