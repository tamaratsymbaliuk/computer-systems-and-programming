package project1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Decompressor {
    public void decompress(String compressedFile, String decompressedFile) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressedFile.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        Map<Integer, String> reverseDictionary = new HashMap<>();
        String line;
        StringBuilder decompressed = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            int code = Integer.parseInt(parts[0]);
            String text = parts[1];
            reverseDictionary.put(code, text);
            decompressed.append(text).append(System.lineSeparator());
        }

        // Write decompressed data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(decompressedFile))) {
            writer.write(decompressed.toString());
        }
    }
    }


